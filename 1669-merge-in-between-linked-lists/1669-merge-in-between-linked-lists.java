class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // Step 1: find node before 'a'
        ListNode prevA = list1;
        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;
        }

        // Step 2: find node after 'b'
        ListNode afterB = prevA;
        for (int i = 0; i < (b - a + 2); i++) {
            afterB = afterB.next;
        }

        // Step 3: connect prevA to list2
        prevA.next = list2;

        // Step 4: traverse list2 till end
        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Step 5: connect tail to afterB
        tail.next = afterB;

        return list1;
    }
}
