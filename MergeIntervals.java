
import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        // Step 2: Merge logic
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                // Overlapping: merge
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // No overlap: add as a new interval
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of intervals:");
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];

        System.out.println("Enter intervals (start end) one by one:");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        sc.close();

        int[][] merged = merge(intervals);

        System.out.println("Merged intervals are:");
        for (int[] interval : merged) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
