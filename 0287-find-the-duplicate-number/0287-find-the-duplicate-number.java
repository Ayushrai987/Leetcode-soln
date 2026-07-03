class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int start = 1;
        int end = n-1;
         while ( start < end) {
            int mid = start + (end-start)/2;
            int count =0;
            for (int num : nums){
                if ( num <= mid) count++;
            }
            if (count >mid){
                end = mid;
            }
            // if(mid<start){
               // start++;
            //}
            else{
                start = mid +1;
            }
         }
         return end;
    }
}