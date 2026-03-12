import java.util.*;

public class import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        // Step 1: If there are 0 or 1 intervals, nothing to merge
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 2: Sort intervals based on the start time
        // This helps us process overlapping intervals sequentially
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Create a list to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Step 4: Take the first interval as the current interval
        int[] current = intervals[0];
        result.add(current);

        // Step 5: Iterate through the remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] next = intervals[i];

            // If the next interval starts before or exactly when
            // the current interval ends, they overlap
            if (next[0] <= current[1]) {

                // Merge them by extending the end of the current interval
                current[1] = Math.max(current[1], next[1]);

            } else {

                // No overlap → add this interval as a new interval
                current = next;
                result.add(current);
            }
        }

        // Step 6: Convert list back to array
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1,3},
            {2,6},
            {8,10},
            {15,18}
        };

        int[][] merged = merge(intervals);

        // Print merged intervals
        for (int[] interval : merged) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
    }
} {

    public static int[][] merge(int[][] intervals) {

        // Step 1: If there are 0 or 1 intervals, nothing to merge
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 2: Sort intervals based on the start time
        // This helps us process overlapping intervals sequentially
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Create a list to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Step 4: Take the first interval as the current interval
        int[] current = intervals[0];
        result.add(current);

        // Step 5: Iterate through the remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] next = intervals[i];

            // If the next interval starts before or exactly when
            // the current interval ends, they overlap
            if (next[0] <= current[1]) {

                // Merge them by extending the end of the current interval
                current[1] = Math.max(current[1], next[1]);

            } else {

                // No overlap → add this interval as a new interval
                current = next;
                result.add(current);
            }
        }

        // Step 6: Convert list back to array
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1,3},
            {2,6},
            {8,10},
            {15,18}
        };

        int[][] merged = merge(intervals);

        // Print merged intervals
        for (int[] interval : merged) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
    }
}

/*
Example

Input

[[1,3],[2,6],[8,10],[15,18]]

Output

[[1,6],[8,10],[15,18]]

Explanation:

[1,3] and [2,6] overlap → merged → [1,6]
[8,10] no overlap
[15,18] no overlap

  Key Idea

1️⃣ Sort intervals by start time
2️⃣ Compare current interval with next interval
3️⃣ If overlapping → merge
4️⃣ If not → add new interval

Time Complexity

Sorting → O(n log n)

Iteration → O(n)
Overall → O(n log n)

Space Complexity

Result list → O(n)

  How do you detect overlap?

next.start <= current.end

If true → intervals overlap.
  */

