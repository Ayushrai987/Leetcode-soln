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
        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            // check if current node is in nums
            if (isInNums(curr.val, nums)) {
                // agar next node null hai ya nums me nahi hai → component complete
                if (curr.next == null || !isInNums(curr.next.val, nums)) {
                    count++;
                }
            }
            curr = curr.next;
        }

        return count;
    }

    // helper function: check if value exists in nums
    private boolean isInNums(int val, int[] nums) {
        for (int num : nums) {
            if (num == val) return true;
        }
        return false;
    }
}
