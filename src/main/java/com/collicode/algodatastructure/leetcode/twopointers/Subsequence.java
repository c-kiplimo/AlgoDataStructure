package com.collicode.algodatastructure.leetcode.twopointers;

class Subsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0; // pointer for s
        int j = 0; // pointer for t

        // Traverse both strings
        while (i < s.length() && j < t.length()) {
            // If characters match, move both pointers
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // Always move j (through t)
            j++;
        }

        // If i reached the end of s, all chars were found in order
        return i == s.length();
    }
}

