class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int i = 0, res = 0, countOdd = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 1) countOdd++; // odd mila toh count++
            
            while (countOdd > k) {
                if (nums[i] % 2 == 1) countOdd--; // left se odd remove
                i++;
            }
            
            res += j - i + 1;
        }
        return res;
    }
}
