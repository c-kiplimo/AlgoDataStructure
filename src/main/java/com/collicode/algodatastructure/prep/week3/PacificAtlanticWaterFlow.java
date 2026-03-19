package com.collicode.algodatastructure.prep.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] h) {
        int m = h.length, n = h[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(h, pac, i, 0);
            dfs(h, atl, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(h, pac, 0, j);
            dfs(h, atl, m - 1, j);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] h, boolean[][] vis, int i, int j) {
        vis[i][j] = true;

        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];

            if (x < 0 || y < 0 || x >= h.length || y >= h[0].length) continue;
            if (vis[x][y] || h[x][y] < h[i][j]) continue;

            dfs(h, vis, x, y);
        }
    }
}
