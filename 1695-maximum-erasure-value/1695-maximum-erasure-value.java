class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set <Integer> set = new HashSet<>();
        int n =nums.length;

            int  i=0;
            int j =0;
            int currSum =0 ;
            int maxSum =0;

            while(j <n){
                while ( set.contains(nums[j])){
                    set.remove(nums[i]);
                    currSum -= nums[i];
                    i++;
                }
                set.add(nums[j]);
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
                j++;


            }
            return maxSum;
    }
}