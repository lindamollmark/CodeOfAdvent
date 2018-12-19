package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dec2Part2 {

    public static void main(final String[] args) throws IOException {

        final List<Character> winner = new ArrayList<>();
        final List<Character> correct = new ArrayList<>();

        final int mistakesAllowed = 1;
        int noOfMistakes = 0;
        final FileReader fileReader = new FileReader("packageId.txt");
        final BufferedReader reader = new BufferedReader(fileReader);

        final Stream<String> lines = reader.lines();
        final List<String> stringSet = lines.collect(Collectors.toList());

        for (int i = 0; i < stringSet.size(); i++) {
            for (int x = i + 1; x < stringSet.size(); x++) {

                final String toCompare = stringSet.get(i);
                final String next = stringSet.get(x);

                for (int n = 0; n < toCompare.length(); n++) {
                    if (toCompare.charAt(n) == next.charAt(n)) {
                        correct.add(toCompare.charAt(n));
                    } else {
                        noOfMistakes++;
                        if (noOfMistakes > mistakesAllowed) {
                            correct.clear();
                            noOfMistakes = 0;
                            break;
                        }
                    }
                }
                winner.addAll(correct);
            }
        }
        winner.forEach(System.out::print);
    }
}
