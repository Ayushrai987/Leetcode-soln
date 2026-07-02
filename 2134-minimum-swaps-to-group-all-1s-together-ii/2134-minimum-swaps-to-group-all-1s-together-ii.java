import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // 1. Circular Array ko handle karne ke liye double size ka array banaya
        // Kyunki array circular hai, isliye end aur start ko connect karne ke liye nums ko 2 baar copy kiya.
        int[] temp = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            temp[i] = nums[i % n]; // % n karne se index dubara 0 se start ho jata hai
        }
        
        // 2. Pure array mein total kitne 1's hain, unka count nikala
        // Yahi countOnes hamari "Sliding Window" ka fixed size (length) hoga.
        int countOnes = Arrays.stream(nums).sum();
        
        // Agar array mein ek bhi 1 nahi hai, ya saare hi 1 hain, to 0 swaps lagenge.
        if (countOnes == 0 || countOnes == n) return 0;
        
        // Pointers aur Counters initialize kiye
        int i = 0;           // Window ka pichla (start) pointer
        int j = 0;           // Window ka aage wala (end) pointer
        int currCount = 0;   // Current window mein kitne 1's hain
        int maxCount = 0;    // Kisi bhi window mein mile maximum 1's ka count
        
        // 3. Sliding Window shuru hoti hai (Khatam hogi 2 * n par)
        while (j < 2 * n) {
            // Agar naya element (jo window mein andar aa raha hai) 1 hai, to count badhao
            if (temp[j] == 1) {
                currCount++;
            }
            
            // Agar window ka size hamare 'countOnes' se bada ho jata hai,
            // toh piche se window ko shrink (chota) karna padega.
            if (j - i + 1 > countOnes) {
                currCount -= temp[i]; // Jo element bahar ja raha hai (index i), agar wo 1 tha to count se ghatao
                i++;                  // Piche wale pointer ko ek step aage badhao
            }
            
            // Har step par check karo ki kya ab tak ki sabse best window mili hai?
            maxCount = Math.max(maxCount, currCount);
            
            // Aage wale pointer ko badhao taaki window aage slide kare
            j++;
        }
        
        // 4. Final Answer: Total 1's mein se minus kar do jo 1's hamein pehle se sath mile.
        // Jo bache hue 1's hain, unhi ko swap karke andar lana padega.
        return countOnes - maxCount;
    }
}