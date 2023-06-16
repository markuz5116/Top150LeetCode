package intermediate_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        System.out.println(Arrays.deepToString(intervals));
        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(interval);
                continue;
            }

            int[] prevInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            if (prevInterval[1] < interval[0]) {
                mergedIntervals.add(interval);
                continue;
            }
            prevInterval[1] = Integer.max(prevInterval[1], interval[1]);
        }
        return mergedIntervals.toArray(new int[0][0]);
    }
}