/*
// Node Definition given by LeetCode
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        // Level ka sabse pehla (leftmost) node track rakhne ke liye
        Node leftmost = root;

        // Jab tak hum leaf level par nahi pahunch jaate
        while (leftmost.left != null) {

            // Current level par travel karne ke liye pointer
            Node curr = leftmost;

            // Current level ke saare nodes par iterate karo
            while (curr != null) {
                
                // Connection 1: Same parent ke left child ko right child se jodo
                curr.left.next = curr.right;

                // Connection 2: Adjacent parents ke children ko aapas mein jodo
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                // Level mein aage (Right) badho
                curr = curr.next;
            }

            // Agle level ke sabse pehle (Leftmost) node par chale jao
            leftmost = leftmost.left;
        }

        return root;
    }
}