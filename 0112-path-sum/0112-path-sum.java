/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        // Current node ki value subtract karo
        targetSum = targetSum - root.val;

        // Leaf node mil gaya
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        // Left ya right mein valid path ho
        return hasPathSum(root.left, targetSum)
            || hasPathSum(root.right, targetSum);
    }
}