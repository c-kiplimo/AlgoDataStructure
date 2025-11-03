package com.collicode.algodatastructure.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int longestSubstringWithoutRepeatingCharacters(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int max_length = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            seen.put(c, seen.getOrDefault(c, 0) + 1);

            while (seen.get(c) > 1) {
                char startchar = s.charAt(start);
                seen.put(startchar, seen.get(startchar) - 1);

                start++;
            }
            max_length = Math.max(max_length, end - start);
        }
        return max_length;
    }
}
