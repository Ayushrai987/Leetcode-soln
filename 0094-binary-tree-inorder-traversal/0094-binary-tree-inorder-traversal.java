import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        // Visit left subtree
        inorder(node.left, result);
        // Visit current node
        result.add(node.val);
        // Visit right subtree
        inorder(node.right, result);
    }
}
