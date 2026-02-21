package com.collicode.algodatastructure.leetcode.arraysandstrings;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        // Create 9 sets for rows
        HashSet<Character>[] rows = new HashSet[9];

        // Create 9 sets for columns
        HashSet<Character>[] cols = new HashSet[9];

        // Create 9 sets for 3x3 boxes
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize all sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse entire 9x9 board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char current = board[r][c];

                // Skip empty cells
                if (current == '.') {
                    continue;
                }

                // Calculate box index
                // Each 3x3 box is identified using:
                // (row / 3) * 3 + (col / 3)
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If number already exists in row → invalid
                if (rows[r].contains(current)) {
                    return false;
                }

                // If number already exists in column → invalid
                if (cols[c].contains(current)) {
                    return false;
                }

                // If number already exists in 3x3 box → invalid
                if (boxes[boxIndex].contains(current)) {
                    return false;
                }

                // Otherwise add number to corresponding sets
                rows[r].add(current);
                cols[c].add(current);
                boxes[boxIndex].add(current);
            }
        }

        // If no duplicates found
        return true;
    }
}