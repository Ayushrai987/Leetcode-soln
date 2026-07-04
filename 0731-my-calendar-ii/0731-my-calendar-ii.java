import java.util.*;

class MyCalendarTwo {
    private TreeMap<Integer, Integer> timeline;

    public MyCalendarTwo() {
        timeline = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Step 1: add event
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);

        // Step 2: check counts
        int active = 0;
        for (int val : timeline.values()) {
            active += val;
            if (active >= 3) {
                // rollback
                timeline.put(start, timeline.get(start) - 1);
                if (timeline.get(start) == 0) timeline.remove(start);

                timeline.put(end, timeline.get(end) + 1);
                if (timeline.get(end) == 0) timeline.remove(end);

                return false;
            }
        }
        return true;
    }
}
