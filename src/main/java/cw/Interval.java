package cw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Interval {

    //This is my solution of task
    public static int sumIntervals(int[][] intervals) {


        if (intervals == null) return 0;
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int max = intervals[0][1];
        int sum = intervals[0][1] - intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= max) {
                sum += intervals[i][1] - intervals[i][0];
                max = intervals[i][1];
            } else if (intervals[i][1] > max) {
                sum -= max - intervals[i][1];
                max = intervals[i][1];
            }
        }
        System.out.println(sum + " - " + sumIntervalsCW(intervals));
        return sum;
    }

    //This is solution form CodeWars
    public static int sumIntervalsCW(int[][] intervals) {

        return intervals == null ? 0 : (int) Arrays.stream(intervals)
                .flatMapToInt(ints -> IntStream.range(ints[0],ints[1]))
                .distinct()
                .count();
//        Stream<int[]> stream = Arrays.stream(intervals);
//        IntStream stream1 = stream.flatMapToInt(new Function<int[], IntStream>() {
//            @Override
//            public IntStream apply(int[] ints) {
//                return IntStream.range(ints[0], ints[1]);
//            }
//        });
//        IntStream stream2 = stream1.distinct();
//        long cnt = stream2.count();
//        return (int) cnt;
    }
}