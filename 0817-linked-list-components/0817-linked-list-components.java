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
    public int numComponents(ListNode head, int[] nums) {
        // Step 1: put nums in a HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int count = 0;
        ListNode curr = head;

        // Step 2: traverse linked list
        while (curr != null) {
            if (set.contains(curr.val) &&
                (curr.next == null || !set.contains(curr.next.val))) {
                count++;
            }
            curr = curr.next;
        }

        return count;
    }
}