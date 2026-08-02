class Solution {
    public long maxPairStrength(int[] nums) {
        long maxStrength = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int g = gcd(nums[i], nums[j]);
                long strength = (1L * nums[i] * nums[j]) / (1L * g * g);
                maxStrength = Math.max(maxStrength, strength);
            }
        }
        return maxStrength;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
