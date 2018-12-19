package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day5part1 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader("longScentence.txt"));

        String polymers = reader.readLine();

        final StringBuilder stringBuilder = new StringBuilder(polymers);
        boolean matchers = false;
        do {
            matchers = false;
            for (int i = 0; i <= stringBuilder.length(); i++) {
                int end = i + 2;
                if (end < stringBuilder.length()) {
                    final char[] twoLetters = stringBuilder.substring(i, i + 2).toCharArray();
                    final char first = twoLetters[0];
                    final char second = twoLetters[1];
                    if (Character.toUpperCase(first) == Character.toUpperCase(second)) {
                        if (first != second) {
                            stringBuilder.deleteCharAt(i);
                            stringBuilder.deleteCharAt(i);
                            matchers = true;
                        }
                    }
                }
            }
        } while (matchers);
        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder);
    }
}
