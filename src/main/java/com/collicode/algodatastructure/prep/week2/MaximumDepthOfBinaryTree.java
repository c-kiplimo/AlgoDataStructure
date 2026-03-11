package com.collicode.algodatastructure.prep.week2;


public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // Base case: empty tree

        // Recursively find depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Maximum depth is 1 (current node) + max of left and right
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
