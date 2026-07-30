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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next;  // first 0 ke baad start
        ListNode ans = new ListNode(0); // result list ka dummy head
        ListNode curr = ans;
        int sum = 0;

        while (temp != null) {
            if (temp.val == 0) {
                // segment khatam → sum ko result mein daal do
                curr.next = new ListNode(sum);
                curr = curr.next;
                sum = 0; // reset
            } else {
                sum += temp.val; // segment ke andar sum add karo
            }
            temp = temp.next;
        }

        return ans.next; // final result list
    }
}
