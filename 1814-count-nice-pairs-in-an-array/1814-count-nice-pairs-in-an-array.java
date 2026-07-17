class Solution {
    final int M = 1000000007;

    public int reverse(int num){
        int rev = 0;

        while( num >0){
            int rem =  num % 10;
            rev = rev * 10 + rem;
            num /= 10;
        }
        return rev;
    }

    public int countNicePairs(int[] nums) {
        int n = nums.length;

        Map<Integer ,  Integer> mp = new HashMap<>();

        for(int i = 0; i<n ; i++){
            nums[i] = nums[i] -  reverse(nums[i]);
        }
        int result = 0;
        for(int i=0; i<n; i++){
            result = (int) ((result + mp.getOrDefault(nums[i], 0)) % M);
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        return result;
        
    }
}