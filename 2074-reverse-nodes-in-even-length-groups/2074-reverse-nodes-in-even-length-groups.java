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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = head;
        ListNode current = head.next;
        int groupSize = 2;

        while (current != null) {
            // Step 1: Count nodes in this group
            int count = 0;
            ListNode temp = current;
            while (temp != null && count < groupSize) {
                temp = temp.next;
                count++;
            }

            // Step 2: Reverse if even length
            if (count % 2 == 0) {
                ListNode newHead = reverseSubList(current, count);
                prev.next = newHead;
                prev = current; // current becomes last after reversal
            } else {
                // skip group
                for (int i = 0; i < count; i++) {
                    prev = current;
                    current = current.next;
                }
            }

            // Step 3: Move to next group
            current = temp;
            groupSize++;
        }
        return head;
    }

    private ListNode reverseSubList(ListNode start, int k) {
        ListNode prev = null;
        ListNode curr = start;
        while (k > 0) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            k--;
        }
        start.next = curr; // connect tail to next group
        return prev;       // new head of reversed sublist
    }
}
