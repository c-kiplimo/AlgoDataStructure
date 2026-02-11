package com.collicode.algodatastructure.leetcode.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class DuplicateCheck {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

}
