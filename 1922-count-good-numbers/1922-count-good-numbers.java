class Solution {
    private long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPlaces = (n + 1) / 2;
        long oddPlaces = n / 2;

        // 5 ki power (evenPlaces) nikalna hai modulo MOD ke sath
        long evenChoices = power(5, evenPlaces);
        
        // 4 ki power (oddPlaces) nikalna hai modulo MOD ke sath
        long oddChoices = power(4, oddPlaces);

        // Dono ko multiply karke final modulo return kar do
        return (int) ((evenChoices * oddChoices) % MOD);
    }

    // Aapka wahi myPow function, bas isme modulo add kiya hai
    private long power(long x, long n) {
        if (n == 0) return 1;
        
        long half = power(x, n / 2);
        
        // Overflow se bachne ke liye har step par % MOD lagana zaroori hai
        long halfSquare = (half * half) % MOD;

        if (n % 2 == 0) {
            return halfSquare;
        } else {
            return (halfSquare * x) % MOD;
        }
    }
}