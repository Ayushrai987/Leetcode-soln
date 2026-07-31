class Solution {
    public int pairSum(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        
        // Step 1: store values
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        
        // Step 2: calculate twin sums
        int n = arr.size();
        int maxSum = 0;
        for (int i = 0; i < n / 2; i++) {
            int sum = arr.get(i) + arr.get(n - 1 - i);
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}
