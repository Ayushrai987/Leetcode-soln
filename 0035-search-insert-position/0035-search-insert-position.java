class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int pos =0;
        for (int i=0; i<n; i++){
            if ( target==nums[i]){
              pos=i;  }
             else if  ( target >=nums[i]){
                pos=i+1;}
                //else {
                   // pos=i-1;
                //}

              }
            
        
        return pos;
    }
}