/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int n = getLength(head);   // length of list
        k = k % n;                 // effective rotations

        // Perform k rotations
        for (int i = 0; i < k; i++) {
            ListNode prev = null, curr = head;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            // curr is last node
            prev.next = null;
            curr.next = head;
            head = curr;
        }
        return head;
    }

    // Helper function to find length
    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
