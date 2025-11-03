package com.collicode.algodatastructure.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int numWords = words.length;
        int windowLen = wordLen * numWords;

        if (s.length() < windowLen) return result;

        // Frequency map of all words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        // Try each possible offset
        for (int i = 0; i < wordLen; i++) {
            int start = i;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            for (int end = i; end + wordLen <= s.length(); end += wordLen) {
                String word = s.substring(end, end + wordLen);

                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // Too many occurrences? Shrink from left
                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(start, start + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        start += wordLen;
                        count--;
                    }

                    // All words matched
                    if (count == numWords) {
                        result.add(start);
                        // Move start ahead to look for next match
                        String leftWord = s.substring(start, start + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        start += wordLen;
                        count--;
                    }

                } else {
                    // Word not in the list — reset window
                    seen.clear();
                    count = 0;
                    start = end + wordLen;
                }
            }
        }

        return result;
    }
}
