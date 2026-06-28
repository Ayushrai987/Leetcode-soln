class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currLength = 0;
        int maxLength = 0;

        for (int num : nums) {
            if (num == 1) {
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            } else {
                currLength = 0; // reset streak
            }
        }

        return maxLength;
    }
}
