package com.collicode.algodatastructure.prep.week4;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Step 1: Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                // No overlap → keep it
                count++;
                prevEnd = intervals[i][1];
            }
        }

        // total intervals - non-overlapping intervals kept
        return intervals.length - (count + 1);
    }
}
