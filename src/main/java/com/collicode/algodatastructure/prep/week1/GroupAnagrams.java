package com.collicode.algodatastructure.prep.week1;

import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Step 1: Create a HashMap
        // Key   -> Sorted version of the word
        // Value -> List of anagrams that match that sorted key
        Map<String, List<String>> map = new HashMap<>();

        // Step 2: Traverse each string in input array
        for (String word : strs) {

            // Step 3: Convert word into character array
            char[] chars = word.toCharArray();

            // Step 4: Sort the character array
            // All anagrams will have the same sorted form
            Arrays.sort(chars);

            // Step 5: Convert sorted char array back to String
            String sortedWord = new String(chars);

            // Step 6: If sorted key is not present in map,
            // create a new ArrayList for that key
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            // Step 7: Add the original word to its corresponding group
            map.get(sortedWord).add(word);
        }

        // Step 8: Return all grouped anagrams
        // map.values() returns Collection<List<String>>
        return new ArrayList<>(map.values());
    }
}
