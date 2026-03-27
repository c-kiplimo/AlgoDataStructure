package com.collicode.algodatastructure.prep.week4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min heap for end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first meeting
        minHeap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // If room is free, reuse it
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            // Allocate room (new or reused)
            minHeap.offer(intervals[i][1]);
        }

        return minHeap.size();
    }
}
