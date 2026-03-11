package com.collicode.algodatastructure.prep.week2;


public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null; // Base case: empty node

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root; // Return the root of inverted tree
    }
}
