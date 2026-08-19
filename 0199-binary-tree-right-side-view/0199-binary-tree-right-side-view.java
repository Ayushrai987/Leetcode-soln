// Approach - 2 (Level Order Traversal)
import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            TreeNode rightNode = null;

            for (int i = 0; i < n; i++) {
                rightNode = queue.poll();

                if (rightNode.left != null)
                    queue.offer(rightNode.left);
                if (rightNode.right != null)
                    queue.offer(rightNode.right);
            }

            // The last node processed at each level is the rightmost one
            result.add(rightNode.val);
        }

        return result;
    }
}
