package com.collicode.algodatastructure.leetcode.arraysandstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            // getOrDefault returns 0 if num is not present
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        /*
         Step 2: Create buckets
         Index = frequency
         Value = list of numbers having that frequency

         Maximum possible frequency is nums.length
        */
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Step 3: Fill buckets
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int freq = entry.getValue();

            bucket[freq].add(number);
        }

        // Step 4: Collect top k frequent elements
        int[] result = new int[k];
        int index = 0;

        // Start from highest possible frequency
        for (int i = nums.length; i >= 0 && index < k; i--) {
            if (!bucket[i].isEmpty()) {
                for (int num : bucket[i]) {
                    result[index++] = num;

                    // Stop when we have collected k elements
                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return result; // Guaranteed to return before this
    }
}
