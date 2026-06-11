package com.collicode.algodatastructure.prep.week1.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // Result array size = number of windows
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Deque to store indices of useful elements for the current window
        Deque<Integer> deque = new ArrayDeque<>();

        // Pointer for result array
        int resIndex = 0;

        for (int i = 0; i < n; i++) {

            // 1. Remove indices that are out of the current window
            // Window range: [i - k + 1, i]
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. Maintain decreasing order in deque
            // Remove elements smaller than current element from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add current index to the deque
            deque.offerLast(i);

            // 4. Start recording results when the first window is complete
            if (i >= k - 1) {
                // Front of deque contains index of max element
                result[resIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}

