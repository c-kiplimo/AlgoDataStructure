package com.collicode.algodatastructure.prep.week1;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        // Edge case: if array is empty, return 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Put all numbers into a HashSet
        // This allows O(1) lookup time
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0; // To store the maximum sequence length found

        // Step 2: Iterate through the set
        for (int num : set) {

            // Only start counting if 'num' is the beginning of a sequence
            // A number is a start if (num - 1) does NOT exist in the set
            if (!set.contains(num - 1)) {

                int currentNum = num;      // Current number in sequence
                int currentStreak = 1;    // Length of current sequence

                // Step 3: Expand forward while next numbers exist
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update longest sequence length
                longest = Math.max(longest, currentStreak);
            }
        }

        // Return the maximum sequence length found
        return longest;
    }
}
