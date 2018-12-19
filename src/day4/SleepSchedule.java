package day4;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class SleepSchedule {

    private final HashMap<Integer, Integer> minutesCounts = new HashMap<>();
    private String id;
    private LocalTime sleepStart = null;
    private LocalTime wakeUp = null;
    private int minutes = 0;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setSleepStart(final LocalTime start) {
        this.sleepStart = start;
    }

    public void setWakeUp(final LocalTime wakeUp) {
        this.wakeUp = wakeUp;
    }

    public int getMinutes() {
        return minutes;
    }

    public HashMap<Integer, Integer> getMinutesCounts() {
        return minutesCounts;
    }

    public void minutesAsleep() {
        final int minute = sleepStart.getMinute();
        final int stop = wakeUp.getMinute();
        for (int min = minute; min < stop; min++) {

            minutesCounts.merge(min, 1, (a, b) -> a + b);
        }
    }

    public int countMinutes() {
        final int sleeping = wakeUp.getMinute() - sleepStart.getMinute();
        minutesAsleep();
        minutes += sleeping;
        return minutes;
    }

    public Map.Entry<Integer, Integer> getTopMinute() {
        Map.Entry<Integer, Integer> topMinute = Map.entry(0, 0);
        if (minutesCounts.size() != 0) {
            return minutesCounts.entrySet().stream()
                    .max(Comparator.comparing(r -> r.getValue()))
                    .get();
        }
        return topMinute;
    }
}