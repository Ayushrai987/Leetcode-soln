/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
   public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;

    // Step 1: Detect cycle (same as Q141)
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) { // cycle detected
            // Step 2: Find cycle start
            slow = head; // reset slow to head
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow; // cycle start node
        }
    }
    return null; // no cycle
}

}