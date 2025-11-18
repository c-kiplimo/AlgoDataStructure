package com.collicode.algodatastructure.leetcode.slidingwindow;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the existing subarray or start a new one
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);

            // Update the global maximum
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
