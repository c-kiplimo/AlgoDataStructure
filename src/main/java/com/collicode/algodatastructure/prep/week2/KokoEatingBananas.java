package com.collicode.algodatastructure.prep.week2;

public class KokoEatingBananas {
    private static boolean canEatAll(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            // Divide pile by k, rounding up
            hours += (pile + k - 1) / k; // ceil(pile/k) without using floating point
        }
        return hours <= h;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1; // minimum possible speed
        int right = 0; // maximum speed = max(piles)
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int result = right; // Initialize result

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, mid, h)) {
                result = mid;      // mid is a valid speed
                right = mid - 1;   // try to find smaller speed
            } else {
                left = mid + 1;    // need a larger speed
            }
        }

        return result;
    }
}
