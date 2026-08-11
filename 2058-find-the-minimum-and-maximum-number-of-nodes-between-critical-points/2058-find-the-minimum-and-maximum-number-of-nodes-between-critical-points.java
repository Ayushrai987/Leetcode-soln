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
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // List to store indices of critical points
        List<Integer> criticalIndices = new ArrayList<>();
        
        // Initialize pointers
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1; // start index from 1 (second node)

        // Traverse until curr.next is available
        while (curr != null && curr.next != null) {
            int nextVal = curr.next.val;

            // Check if current node is local maxima or minima
            if ((curr.val > prev.val && curr.val > nextVal) ||
                (curr.val < prev.val && curr.val < nextVal)) {
                criticalIndices.add(index);
            }

            // Move forward
            prev = curr;
            curr = curr.next;
            index++;
        }

        // If less than 2 critical points → no valid distance
        if (criticalIndices.size() < 2) {
            return new int[]{-1, -1};
        }

        // Calculate min distance between consecutive critical points
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < criticalIndices.size(); i++) {
            minDist = Math.min(minDist, criticalIndices.get(i) - criticalIndices.get(i - 1));
        }

        // Max distance = last - first critical point
        int maxDist = criticalIndices.get(criticalIndices.size() - 1) - criticalIndices.get(0);

        return new int[]{minDist, maxDist};
    }
}

