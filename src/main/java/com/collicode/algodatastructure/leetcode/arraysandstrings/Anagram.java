package com.collicode.algodatastructure.leetcode.arraysandstrings;

public class Anagram {

    public boolean isAnagram(String s, String t) {

        // If lengths are different, they cannot be anagrams.
        // Anagrams must contain exactly the same number of characters.
        if (s.length() != t.length()) {
            return false;
        }

        // Create a frequency counter for lowercase English letters.
        // Size 26 because there are 26 letters from 'a' to 'z'.
        // count[i] will store the net frequency difference for character (char)(i + 'a')
        int[] count = new int[26];

        // Traverse both strings at the same time.
        for (int i = 0; i < s.length(); i++) {

            // Increase the count for the character in string s.
            // Example: if s.charAt(i) is 'c'
            // 'c' - 'a' gives index 2
            count[s.charAt(i) - 'a']++;

            // Decrease the count for the character in string t.
            // This cancels out matching characters.
            count[t.charAt(i) - 'a']--;
        }

        // After processing both strings,
        // every count should be zero if they are anagrams.
        // Non-zero means mismatch in character frequency.
        for (int c : count) {
            if (c != 0) {
                return false;  // mismatch found
            }
        }

        // All counts are zero → perfect match
        return true;
    }
}
