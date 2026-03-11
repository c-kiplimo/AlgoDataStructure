package com.collicode.algodatastructure.prep.week2;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInOrderPreOrderTraversal {
    private int preIndex = 0; // index for preorder array

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a map from value to index in inorder array
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1, inorderIndexMap);
    }

    private TreeNode helper(int[] preorder, int inStart, int inEnd, Map<Integer, Integer> inorderIndexMap) {
        if (inStart > inEnd) return null; // no nodes to construct

        // Root value is the current element in preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find the root index in inorder array
        int inIndex = inorderIndexMap.get(rootVal);

        // Recursively build left and right subtrees
        root.left = helper(preorder, inStart, inIndex - 1, inorderIndexMap);
        root.right = helper(preorder, inIndex + 1, inEnd, inorderIndexMap);

        return root;
    }
}
