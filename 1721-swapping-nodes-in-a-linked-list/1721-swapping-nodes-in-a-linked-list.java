class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // Step 1: find length
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Step 2: find k-th node from start
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Step 3: find k-th node from end
        ListNode second = head;
        for (int i = 1; i < n - k + 1; i++) {
            second = second.next;
        }

        // Step 4: swap values
        int val = first.val;
        first.val = second.val;
        second.val = val;

        return head;
    }
}
