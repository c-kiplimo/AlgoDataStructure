package com.collicode.algodatastructure.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int longestSubstringWithoutRepeatingCharacters(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int max_length = 0;
        int start = 0;

        if (s == null) {
            return 0; // optional safety check
        }

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            // Increment count of current character
            seen.put(c, seen.getOrDefault(c, 0) + 1);

            // If there's a duplicate, shrink window from the left
            while (seen.get(c) > 1) {
                char startChar = s.charAt(start);
                seen.put(startChar, seen.get(startChar) - 1);
                start++;
            }

            // Update maximum length (add +1 to include both ends)
            max_length = Math.max(max_length, end - start + 1);
        }

        return max_length;

    }
}
