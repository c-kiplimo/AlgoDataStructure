package com.collicode.algodatastructure.prep.week2;

public class KthSmallestElementInABST {
    private int count = 0; // to count visited nodes
    private int result = 0; // store the kth smallest value

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        // Visit left subtree first
        inorder(node.left, k);

        // Visit current node
        count++;
        if (count == k) {
            result = node.val;
            return; // stop traversal once kth smallest is found
        }

        // Visit right subtree
        inorder(node.right, k);
    }
}
