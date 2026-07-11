class Solution {
    public double myPow(double x, int n) {
        // 'n' ko long mein convert kiya taaki Integer.MIN_VALUE overflow na kare
        long N = n;
        
        // Agar N negative hai, toh x ko ulta (1/x) kar do aur N ko positive
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return helper(x, N);
    }
    
    // Ek helper function jo actual recursion sambhalega
    private double helper(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        
        double half = helper(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}