package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class Dec1Part2 {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> frequencyList = new ArrayList<>();
        int frequency = 0;
        boolean readFile = true;
        while (readFile) {
            FileReader fileReader = new FileReader("Frequency.txt");
            final BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                if (!readFile) {
                    break;
                }
                final char countSymbol = line.charAt(0);
                final int number = Integer.parseInt(line.substring(1));
                if (countSymbol == '+') {
                    frequency += number;
                } else {
                    frequency -= number;
                }
                final int resultingFrequency = frequency;
                final Optional<Integer> match = frequencyList.stream()
                        .filter(n -> n == resultingFrequency)
                        .findFirst();
                if (match.isPresent()) {
                    System.out.println("First match: " + match.get());
                    readFile = false;
                    break;
                }

                frequencyList.add(resultingFrequency);

            }
            System.out.println("List slut frekvens: " + frequency);
        }
    }
}
