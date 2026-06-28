class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLen = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink window if more than 1 zero
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update max length (delete one element → window size - 1)
            maxLen = Math.max(maxLen, right - left);
            right++;
        }

        return maxLen;
    }
}
