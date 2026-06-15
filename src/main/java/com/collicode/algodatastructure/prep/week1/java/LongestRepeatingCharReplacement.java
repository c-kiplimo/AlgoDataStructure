package com.collicode.algodatastructure.prep.week1.java;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement {
    public Integer characterReplacement(String s, Integer k) {
        // Sliding window approach: track character frequencies and find longest valid window
        if (s.isEmpty()) return 0;

        Map<Character, Integer> charCount = new HashMap<>();  // Track character frequencies in current window
        int maxFreq = 0;        // Most frequent character count in current window
        int maxLength = 0;      // Maximum valid window length found
        int start = 0;          // Left boundary of sliding window

        // Expand window by moving right boundary
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            // Add current character to window
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, charCount.get(ch));

            // Shrink window if it becomes invalid (need > k replacements)
            // Window size - most frequent count = replacements needed
            while ((end - start + 1) - maxFreq > k) {
                char leftChar = s.charAt(start);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                start++; // Move left boundary right
            }

            // Update maximum valid window length
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
