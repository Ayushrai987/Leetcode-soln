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
import java.util.HashMap;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int prefix = 0;
        HashMap<Integer, ListNode> map = new HashMap<>();

        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefix += curr.val;

            if (map.containsKey(prefix)) {
                ListNode prev = map.get(prefix);
                ListNode temp = prev.next;
                int sum = prefix;
                while (temp != curr) {
                    sum += temp.val;
                    map.remove(sum);
                    temp = temp.next;
                }
                prev.next = curr.next;
            } else {
                map.put(prefix, curr);
            }
        }
        return dummy.next;
    }
}
