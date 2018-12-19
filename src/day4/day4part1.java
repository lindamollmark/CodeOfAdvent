package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class day4part1 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader("sleepFile.txt"));

        final List<String> sleepList = reader.lines().collect(Collectors.toList());
        Collections.sort(sleepList);
        final HashMap<String, SleepSchedule> sleep = new HashMap<>();
        final String[] id = {""};
//         String line;
//         while ((line = sleepList.f) != null) {
        sleepList.forEach(line -> {
            final String timeStamp = line.substring(1, 17);
            final String[] dateTime = timeStamp.split(" ");
            final LocalTime time = LocalTime.parse(dateTime[1]);
            final int idStartPos = line.lastIndexOf('#');
            if (idStartPos != -1) {
                id[0] = line.substring(idStartPos + 1, line.indexOf(" ", idStartPos));
                if (sleep.get(id[0]) == null) {
                    final SleepSchedule sleepSchedule = new SleepSchedule();
                    sleep.putIfAbsent(id[0], sleepSchedule);
                }
                sleep.get(id[0]).setId(id[0]);
            }
            if (line.indexOf("fall") > 0) {
                sleep.get(id[0]).setSleepStart(time);
            }
            if (line.indexOf("wakes") > 0) {
                final SleepSchedule sleeps = sleep.get(id[0]);
                sleeps.setWakeUp(time);
                sleeps.countMinutes();

            }
        });
        final SleepSchedule sleepSchedule = sleep.entrySet().stream().max(Comparator.comparing(s -> s.getValue().getMinutes())).map(Map.Entry::getValue).get();
        final int topId = Integer.parseInt(sleepSchedule.getId());
        final int topMinute = sleepSchedule.getTopMinute().getKey();

        System.out.println(topId * topMinute);
    }
}