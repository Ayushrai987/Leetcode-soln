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
import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Step 1: Put nums into a set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 2: Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 3: Traverse
        ListNode prev = dummy, curr = head;
        while (curr != null) {
            if (set.contains(curr.val)) {
                // Delete node
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        // Step 4: Return new head
        return dummy.next;
    }
}
