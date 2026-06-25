class Solution {
    public void moveZeroes(int[] nums) {
         int n = nums.length;
      int insertPos =0;
      
      for ( int num: nums){
        if (num != 0){
            nums[insertPos++] = num;
        }
      }
      while (insertPos < n){
        nums[insertPos++] =0;
      }
        }
    
}