package com.collicode.algodatastructure.prep.week1.kotlin


class ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0

        while (left < right) {
            val width = right - left
            val minHeight = minOf(height[left], height[right])

            maxArea = maxOf(maxArea, width * minHeight)

            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }

        return maxArea
    }
}