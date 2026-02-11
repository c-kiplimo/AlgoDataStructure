package com.collicode.algodatastructure.leetcode.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int longestSubstringWithoutRepeatingCharacters(String s) {
        Map<Character, Integer> state = new HashMap<>();
        int maxLength = 0;
        int start = 0;


        for (int end = 0; end < s.length(); end++) {


            if (state.containsKey(s.charAt(end))) {
                start = Math.max(start, state.get(s.charAt(end)) + 1);
            }
            state.put(s.charAt(end), end);

            // Update maximum length (add +1 to include both ends)
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;

    }
}
