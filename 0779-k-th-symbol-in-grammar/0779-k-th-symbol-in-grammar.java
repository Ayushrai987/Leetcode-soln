class Solution {
    public int kthGrammar(int n, int k) {
        // STEP 1: Base Case (Sabse choti input par kab rukna hai)
        // Row 1 me hamesha sirf ek hi element hota hai, jo ki '0' hai.
        if (n == 1) {
            return 0;
        }

        // STEP 2: Mid point nikaalo
        // Row 'n' ki total length 2^(n-1) hoti hai, toh uska aadha (mid) hoga 2^(n-2).
        int mid = (int) Math.pow(2, n - 2);

        // STEP 3: Left Half ya Right Half ka decision lo
        
        // Case A: Agar K mid se chota ya barabar hai, matlab wo Left Half me hai.
        // Left half bilkul pichli row (n-1) ki tarah dikhta hai.
        if (k <= mid) {
            return kthGrammar(n - 1, k);
        } 
        
        // Case B: Agar K mid se bada hai, matlab wo Right Half me hai.
        // Right half pichli row (n-1) ke relative element ka ekdam ULTA (flip) hota hai.
        else {
            // Pichli row me iski relative position nikalne ke liye (k - mid) karenge
            int pichlaAns = kthGrammar(n - 1, k - mid);
            
            // Agar pichla answer 0 tha toh 1 return karo, agar 1 था toh 0 return karo
            if (pichlaAns == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}