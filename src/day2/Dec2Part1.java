package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class Dec2Part1 {

    public static void main(String[] args) throws IOException {


        long numberOfduplicates = 0;
        long numberOftripplets = 0;
        FileReader fileReader = new FileReader("packageId.txt");
        final BufferedReader reader = new BufferedReader(fileReader);

        String line = null;
        while ((line = reader.readLine()) != null) {

            final Map<String, Long> collect = line.chars()
                    .mapToObj(e -> (char) e)
                    .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

            numberOfduplicates += collect.values().stream().filter(i -> i == 2).distinct().count();
            numberOftripplets += collect.values().stream().filter(i -> i == 3).distinct().count();

        }
        System.out.println("Checksum = " + numberOfduplicates * numberOftripplets);

    }
}
