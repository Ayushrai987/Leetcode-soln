class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        // Step 1: Create an array to store the maximum values from the right side.
        // maxRight[i] = maximum element in nums[i...n-1]
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];  // last element is itself

        // Fill the maxRight array from right to left
        for (int i = n - 2; i >= 0; i--) {
            // At each position, take max of current element and the max to its right
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        // Step 2: Two pointers i (left) and j (right)
        int ramp = 0;  // store maximum width ramp found
        int i = 0;     // left pointer
        int j = 0;     // right pointer

        // Step 3: Traverse with j from 0 to n-1
        while (j < n) {
            // If nums[i] is greater than maxRight[j], then i cannot form a ramp with j
            // So move i forward until condition nums[i] <= maxRight[j] holds
            while (i < j && nums[i] > maxRight[j]) {
                i++;
            }

            // Now nums[i] <= maxRight[j], so (i, j) is a valid ramp
            // Update maximum width
            ramp = Math.max(ramp, j - i);

            // Move j forward to check next possible ramp
            j++;
        }

        // Step 4: Return the maximum width ramp found
        return ramp;
    }
}
