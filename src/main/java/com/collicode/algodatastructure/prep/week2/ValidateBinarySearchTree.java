package com.collicode.algodatastructure.prep.week2;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    // Helper function: min and max represent the valid range for node values
    private boolean helper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true; // Empty node is valid

        // Check current node against min and max
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Left subtree must be < node.val, right subtree must be > node.val
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
