package com.collicode.algodatastructure.prep.week2;

public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE; // Global maximum path sum

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    // Returns the maximum sum of a path that **starts at this node and goes downward**
    private int helper(TreeNode node) {
        if (node == null) return 0;

        // Recursively get max path sums from left and right, ignore negatives
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        // Maximum path sum **through this node** (could include both left and right)
        int currentPathSum = node.val + left + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPathSum);

        // Return max path sum **starting from this node** going down
        return node.val + Math.max(left, right);
    }
}
