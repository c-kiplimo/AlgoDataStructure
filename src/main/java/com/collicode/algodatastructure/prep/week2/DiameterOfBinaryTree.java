package com.collicode.algodatastructure.prep.week2;

public class DiameterOfBinaryTree {
    private int maxDiameter = 0; // store the maximum diameter

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    // Helper function returns the depth of a node
    private int dfs(TreeNode node) {
        if (node == null) return 0; // base case: empty node

        int leftDepth = dfs(node.left);   // depth of left subtree
        int rightDepth = dfs(node.right); // depth of right subtree

        // Update maximum diameter if path through this node is longer
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // Return depth of this node
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
