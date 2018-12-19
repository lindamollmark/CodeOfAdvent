package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class day5part2 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader("longScentence.txt"));

        String polymers = reader.readLine();
//        String polymers = "dabAcCaCBAcCcaDA";

        String alphabet = "abcdefghijklmnopqrstuvxyz";
        StringBuilder stringBuilder;
        Map<Character, String> transformed = new HashMap<>();
        final List<Character> characterList = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        for (Character l : characterList) {
            final String toUpperchars = polymers.replace(Character.toUpperCase(l), l);
            final String withoutLetter = toUpperchars.replace(l.toString(), "");


            stringBuilder = new StringBuilder(withoutLetter);

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
                transformed.put(l, stringBuilder.toString());
            } while (matchers);
        }

        final Map.Entry<Character, String> stringEntry = transformed.entrySet().stream().min(Comparator.comparing(c -> c.getValue().length())).get();
        System.out.println("Bokstaven " + stringEntry.getKey() + " förkortade listan mest till " + stringEntry.getValue().length() + " bokstäver");
//        System.out.println(stringBuilder.length());
//        System.out.println(stringBuilder);
    }
}
