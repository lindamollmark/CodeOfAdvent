package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dec1Part1 {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("Frequency.txt");

        final BufferedReader reader = new BufferedReader(fileReader);
        String line;
        int frequency = 0;
        while ((line = reader.readLine()) != null) {

            final char countSymbol = line.charAt(0);
            final int number = Integer.parseInt(line.substring(1));
            if (countSymbol == '+') {
                frequency = frequency + number;
            } else {
                frequency -= number;
            }
        }
        System.out.println(frequency);
    }
}
