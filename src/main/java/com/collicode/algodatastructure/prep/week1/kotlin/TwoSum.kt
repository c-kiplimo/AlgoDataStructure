package com.collicode.algodatastructure.prep.week1.kotlin


class Solution {

    fun twoSum(numbers: IntArray, target: Int): IntArray? {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val sum = numbers[left] + numbers[right]

            when {
                sum > target -> right--
                sum < target -> left++
                else -> return intArrayOf(left + 1, right + 1)
            }
        }

        return null
    }
}



class Solution2 {

    fun twoSum(numbers: IntArray, target: Int): IntArray? {
        val map = mutableMapOf<Int, Int>()

        for (i in numbers.indices) {
            val complement = target - numbers[i]

            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!! + 1, i + 1)
            }

            map[numbers[i]] = i
        }

        return null
    }
}