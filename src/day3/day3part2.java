package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day3part2 {

    public static void main(final String[] args) throws IOException {
        final HashMap<String, FabricClaim> claimMap;
        final String[][] fabric = new String[1000][1000];
        final int[] count = {0};
        final Stream<String> lines = new BufferedReader(new FileReader("fabricClaimList.txt")).lines();

        claimMap = lines.map(l -> new ArrayList<>(Arrays.asList(l.split("\\D", -1)))).map(strings -> strings.stream()
                .filter(s -> !s.equalsIgnoreCase(""))
                .collect(Collectors.toList()))
                .collect(Collectors.toMap(stringList -> stringList.get(0), stringList -> new FabricClaim(
                                stringList.get(1)
                                , stringList.get(2)
                                , stringList.get(3)
                                , stringList.get(4))
                        , (a, b) -> b
                        , HashMap::new));

        claimMap.forEach((key, claim) -> {
            final int noOfRows = claim.getNoOfRows();
            final int noOfColumn = claim.getNoOfColumn();
            for (int r = 0; r < noOfRows; r++) {
                final int startColumn = claim.getStartColumn() + r;
                for (int c = 0; c < noOfColumn; c++) {

                    final int startRow = claim.getStartRow();
                    final String spot = fabric[startColumn][startRow + c];
                    if (spot == null) {
                        fabric[startColumn][startRow + c] = key;
                    } else if (!spot.equalsIgnoreCase("X")) {
                        final String marked = fabric[startColumn][startRow + c];
                        claimMap.get(marked).overlap(true);
                        fabric[startColumn][startRow + c] = "X";
                        count[0]++;
                        claim.overlap(true);
                    } else if (spot.equalsIgnoreCase("X")) {
                        claim.overlap(true);
                    }

                }

            }
        });

        System.out.println(count[0]);
        claimMap.entrySet().stream()
                .filter(f -> !f.getValue().overlap())
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

    }
}