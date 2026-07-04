class Solution {
    public int arrangeCoins(int n) {
        long low =0;
        long high = n;
        while (low <= high){
            long mid = low + (high - low)/2;
            long coinsNeeded = mid* (mid+1)/2;
            if(coinsNeeded == n){
                return (int) mid;
            } else if(coinsNeeded < n){
                low = mid + 1 ;
            } else{
                high = mid - 1;
            }
           
        }
         return(int) high;

            }

        }
    
