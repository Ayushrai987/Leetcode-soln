import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // Prefix sum array long mein banate hain taaki overflow na ho
        long[] pSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pSum[i + 1] = pSum[i] + nums[i];
        }

        // Deque indices store karegi
        Deque<Integer> dq = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            // 1. FRONT SE CHECK: Agar sum >= k ho gaya, toh answer update karo aur front hatao
            while (!dq.isEmpty() && pSum[i] - pSum[dq.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - dq.pollFirst());
            }

            // 2. BACK SE CHECK: Monotonicity maintain karo (chhoti/equal values ko hatao)
            while (!dq.isEmpty() && pSum[i] <= pSum[dq.peekLast()]) {
                dq.pollLast();
            }

            // Current index ko deque mein daal do
            dq.addLast(i);
        }

        // Agar minLength change nahi hui, matlab aisa koi subarray mila hi nahi (-1 return karo)
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}