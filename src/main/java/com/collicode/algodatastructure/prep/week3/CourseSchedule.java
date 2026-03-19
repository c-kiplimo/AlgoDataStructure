package com.collicode.algodatastructure.prep.week3;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prereq) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] p : prereq) graph.get(p[1]).add(p[0]);

        int[] visited = new int[numCourses]; // 0=unvisited,1=visiting,2=done

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> g, int[] v, int i) {
        if (v[i] == 1) return false;
        if (v[i] == 2) return true;

        v[i] = 1;
        for (int nei : g.get(i)) {
            if (!dfs(g, v, nei)) return false;
        }
        v[i] = 2;
        return true;
    }
}
