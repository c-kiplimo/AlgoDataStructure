package com.collicode.algodatastructure.prep.week3;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] c, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), c, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur,
                           int[] c, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < c.length; i++) {
            if (c[i] > target) continue;

            cur.add(c[i]);
            backtrack(res, cur, c, target - c[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}
