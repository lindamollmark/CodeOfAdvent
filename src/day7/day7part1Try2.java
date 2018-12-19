package day7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class day7part1Try2 {

    public static void main(String[] args) throws FileNotFoundException {

        //Läser in listan osorterat
        final BufferedReader reader = new BufferedReader(new FileReader("stepsUnorderedTest.txt"));
        final List<String> unorderedList = reader.lines().collect(Collectors.toList());
        final Set<String> toBeInList = new HashSet<>();

        //Går igenom listan och tar bort onödig text
        int i = 0;
        final int listSize = unorderedList.size();
        while (i < listSize) {
            final String firstLetter = unorderedList.get(0).substring(5, 6);
            final String secondLetter = unorderedList.get(0).substring(36, 37);
            // Tar bort raden med text
            unorderedList.remove(0);
            unorderedList.add(firstLetter + " " + secondLetter);
            //Lägger till alla bokstäver som finns med i listan
            toBeInList.add(firstLetter);
            toBeInList.add(secondLetter);

            i++;
        }
        Set<Character> sorted = new LinkedHashSet<>();
        final List<String> result = new ArrayList<>();
        unorderedList.sort(Comparator.reverseOrder());

        unorderedList.stream().forEach(l -> {
            if (sorted.contains(l)) {
                sorted.remove(l);
            }
            sorted.add(l.charAt(2));
            sorted.add(l.charAt(0));
            System.out.println(l);
        });
        for (String c : unorderedList) {
            result.add(c.substring(2, 3));
        }
        final Set<String> missingInList = toBeInList.stream().filter(l -> !result.contains(l)).collect(Collectors.toSet());
        result.addAll(missingInList);
        final LinkedHashSet<String> strings = new LinkedHashSet<>(result);
        strings.forEach(System.out::print);

    }
}
