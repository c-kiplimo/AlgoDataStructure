package com.collicode.algodatastructure.prep.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int n, int[][] prereq) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        int[] indegree = new int[n];

        for (int[] p : prereq) {
            g.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int[] res = new int[n];
        int idx = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            res[idx++] = cur;

            for (int nei : g.get(cur)) {
                if (--indegree[nei] == 0) q.add(nei);
            }
        }

        return idx == n ? res : new int[0];
    }
}
