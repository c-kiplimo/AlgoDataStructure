package com.collicode.algodatastructure.leetcode.arraysandstrings;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

    /*
     * ENCODE
     * ------
     * Converts a list of strings into one single string.
     *
     * Strategy:
     * For each string:
     *   1. Get its length
     *   2. Append length
     *   3. Append a separator '#'
     *   4. Append the actual string
     *
     * Example:
     * ["Hello","World"]
     *
     * Encoded form:
     * "5#Hello5#World"
     *
     * Why this works:
     * We always know how many characters to read after '#'.
     * So even if the string contains '#', it won't break decoding.
     */
    public String encode(List<String> strs) {

        // StringBuilder is more efficient than string concatenation
        StringBuilder sb = new StringBuilder();

        // Iterate through each string in the list
        for (String str : strs) {

            // Append string length
            sb.append(str.length());

            // Append delimiter
            sb.append('#');

            // Append actual string
            sb.append(str);
        }

        // Return final encoded string
        return sb.toString();
    }


    /*
     * DECODE
     * ------
     * Converts the encoded string back into the original list of strings.
     *
     * Strategy:
     * 1. Start from index 0.
     * 2. Read characters until '#' to get the length.
     * 3. Convert length substring to integer.
     * 4. Read exactly 'length' characters after '#'.
     * 5. Add extracted string to result list.
     * 6. Move pointer forward and repeat.
     */
    public List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        int i = 0;  // Pointer to traverse encoded string

        // Continue until we process entire encoded string
        while (i < s.length()) {

            int j = i;

            // Step 1: Move j forward until we find '#'
            // This gives us the substring representing the length
            while (s.charAt(j) != '#') {
                j++;
            }

            // Step 2: Extract length substring and convert to integer
            int length = Integer.parseInt(s.substring(i, j));

            // Step 3: Move j past '#'
            j++;

            // Step 4: Extract the actual string using known length
            String str = s.substring(j, j + length);

            // Step 5: Add extracted string to result
            result.add(str);

            // Step 6: Move i pointer to next encoded segment
            i = j + length;
        }

        return result;
    }
}