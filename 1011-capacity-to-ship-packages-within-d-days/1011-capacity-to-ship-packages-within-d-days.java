class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int left = 0;
        int right = 0;
        for(int w : weights){
            left = Math.max(left, w);
            right += w;
        }
        while(left < right){
            int mid = left + (right-left)/2;
            if(canShip(weights, days, mid)){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
    private boolean canShip(int[] weights,
     int D, int capacity){ 
        int days = 1, current = 0;
         for(int w : weights){ 
            if(current + w > capacity){ 
                days++; current = 0; } 
                current += w; } 
                return days <= D; }
}