package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class day3part1 {

    public static void main(final String[] args) throws IOException {
        final HashMap<String, FabricClaim> claimMap = new HashMap<>();
        final String[][] fabric = new String[1000][1000];
        final int[] count = {0};
        final FileReader fileReader = new FileReader("fabricClaimList.txt");
        final BufferedReader reader = new BufferedReader(fileReader);

        reader.lines().forEach(l -> {
            final ArrayList<String> strings = new ArrayList<>(Arrays.asList(l.split("\\D", -1)));

            final List<String> stringList = strings.stream().filter(s -> !s.equalsIgnoreCase("")).collect(Collectors.toList());

            claimMap.put(stringList.get(0), new FabricClaim(stringList.get(1), stringList.get(2), stringList.get(3), stringList.get(4)));
        });
        claimMap.entrySet().forEach(n -> {
            final FabricClaim claim = n.getValue();
            final int noOfRows = claim.getNoOfRows();
            final int noOfColumn = claim.getNoOfColumn();
            for (int r = 0; r < noOfRows; r++) {
                final int startColumn = claim.getStartColumn() + r;
                for (int c = 0; c < noOfColumn; c++) {

                    final int startRow = claim.getStartRow();
                    if (fabric[startColumn][startRow + c] == null) {
                        fabric[startColumn][startRow + c] = n.getKey();
                    } else if (!fabric[startColumn][startRow + c].equalsIgnoreCase("X")) {
                        fabric[startColumn][startRow + c] = "X";
                        count[0]++;
                    }

                }

            }
        });
//            fabric[Integer.parseInt(stringList.get(1))][Integer.parseInt(stringList.get(2))] = stringList.get(0);


        System.out.println(count[0]);
    }
}