package com.collicode.algodatastructure.prep.week3;

import java.util.PriorityQueue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> dist(b) - dist(a)
        );

        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > k) pq.poll();
        }

        return pq.toArray(new int[k][]);
    }

    private int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
