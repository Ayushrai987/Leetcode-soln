class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // Edge Case 1 & 2: Agar bina khele result pata ho
        // Agar k = 0 hai, toh pehle hi rukna padega.
        // Agar k - 1 + maxPts <= n hai, toh sabse kharab kismat me bhi n cross nahi hoga.
        if (k == 0 || k - 1 + maxPts <= n) {
            return 1.0;
        }

        // chances array har score par aane ki probability store karega
        double[] chances = new double[n + 1];
        chances[0] = 1.0; // 0 score par hum shuruwat me hote hi hain (100% chance)
        
        double windowSum = 1.0; // Yeh humara pichle maxPts chances ka total rakhega
        double result = 0.0;    // Final jeetne ki probability yahan judegi

        // 1 se lekar n tak har score ke chances calculate karenge
        for (int i = 1; i <= n; i++) {
            
            // Current score i par aane ka chance = (pichle allowed scores ka total) / maxPts
            chances[i] = windowSum / maxPts;

            // Agar naya score i humari greed limit 'k' se kam hai
            if (i < k) {
                windowSum = windowSum + chances[i]; // Toh is naye chance ko box me daal lo
            } else {
                // Agar i >= k ho gaya, matlab ab aur spin nahi kar sakte.
                // Par kyunki ye score 'n' ke andar hai (loop i <= n tak chal raha hai), 
                // toh hum jeet gaye! Is chance ko final result me jod lo.
                result = result + chances[i];
            }

            // Box (window) ko aage badhana hai.
            // Agar hum maxPts kadam se aage nikal gaye hain, toh sabse pichla chance hata do
            if (i - maxPts >= 0) {
                windowSum = windowSum - chances[i - maxPts];
            }
        }

        return result;
    }
}