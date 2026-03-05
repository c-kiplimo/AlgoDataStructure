package com.collicode.algodatastructure.prep.week1;


public class TrappingRainWater {
    public int trappingWater(int[] height) {
        // Handle empty array edge case
        if (height == null || height.length == 0) {
            return 0;
        }
        // Initialize two pointers at the ends of the array
        int left = 0, right = height.length - 1;
        // Track the maximum height seen so far from each side
        int leftMax = height[left], rightMax = height[right];
        int count = 0;
        // Use two-pointer technique to calculate trapped water
        while (left + 1 < right) {
            // Move pointer from the side with smaller maximum height
            if (rightMax > leftMax) {
                left++;
                // Update leftMax or add trapped water
                if (height[left] > leftMax) {
                    leftMax = height[left]; // New maximum found
                } else {
                    count += leftMax - height[left]; // Water trapped
                }
            } else {
                right--;
                // Update rightMax or add trapped water
                if (height[right] > rightMax) {
                    rightMax = height[right]; // New maximum found
                } else {
                    count += rightMax - height[right]; // Water trapped
                }
            }
        }
        return count;
    }
}

