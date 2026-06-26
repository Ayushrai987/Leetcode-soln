class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int  maxLen=0;
        int left = 0;
        int zeroCount = 0;


        for( int i=0; i<n; i++){
            if(nums[i] == 0){
            zeroCount++;
    }
    while ( zeroCount > k){
        if(nums[left] == 0){
            zeroCount--;
        }
        left++;

    }
     maxLen = Math.max(maxLen, i - left + 1);
    }
    return maxLen;
}
}
