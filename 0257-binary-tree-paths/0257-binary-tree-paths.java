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
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        helper(root, "", result);

        return result;
    }

    private void helper(TreeNode node, String path, List<String> result) {

        // Current node ko path mein add karo
        if (path.equals("")) {
            path = String.valueOf(node.val);
        } else {
            path = path + "->" + node.val;
        }

        // Leaf node mil gaya
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // Left subtree
        if (node.left != null) {
            helper(node.left, path, result);
        }

        // Right subtree
        if (node.right != null) {
            helper(node.right, path, result);
        }
    }
}