package cw;

import java.util.Arrays;
import java.util.Comparator;

public class Interval {

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null) return 0;
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int sum = intervals[0][1] - intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1][1] < intervals[i][1]) {
                if (intervals[i-1][1] > intervals[i][0]) {
                    sum -= intervals[i-1][1] - intervals[i][1];
                } else {
                    sum += intervals[i][1] - intervals[i][0];
                }
            }
        }
        return sum;
    }
}