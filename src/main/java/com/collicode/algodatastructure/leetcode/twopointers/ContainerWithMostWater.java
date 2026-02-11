package com.collicode.algodatastructure.leetcode.twopointers;

public class ContainerWithMostWater {


    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int height1 = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * height1);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;

    }
}
