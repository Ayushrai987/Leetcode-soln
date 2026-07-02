//Approach-1 (Using extra space + Khandani Sliding Window)
//T.C : O(n)
//S.C : O(2*n) ~ O(n)
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


//Approach-2 (Khandani Sliding Window without extra space)
//T.C : O(n)
//S.C : O(1)
import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // 1. Pure array mein total kitne 1's hain, unka sum nikala.
        // Yahi countOnes hamari fixed-size "Sliding Window" ki length hogi.
        int countOnes = Arrays.stream(nums).sum();

        // Edge Case: Agar ek bhi 1 nahi hai ya saare hi 1 hain, to koi swap nahi chahiye.
        if (countOnes == 0 || countOnes == n) return 0;

        int i = 0;           // Window ka starting (pichla) pointer
        int j = 0;           // Window ka ending (aage wala) pointer
        int currCount = 0;   // Current window mein kitne 1's hain
        int maxCount = 0;    // Kisi bhi window mein mile maximum 1's ka count

        // 2. Loop 2 * n tak chalega taaki circular array ko scan kiya ja sake.
        // Hum bina koi naya array banaye, sirf index ko virtual tarike se double ghumayenge.
        while (j < 2 * n) {
            
            // nums[j % n] se hum circular index par pahunchte hain.
            // Eg: Agar n=7 hai aur j=7 hua, to 7 % 7 = 0 (wapas start par aa gaye).
            if (nums[j % n] == 1) {
                currCount++;
            }

            // 3. Agar window ka size hamare required 'countOnes' se bada ho jata hai,
            // toh piche se window ko shrink (chota) karna shuru karenge.
            if (j - i + 1 > countOnes) {
                // Jo element piche se bahar nikal raha hai (nums[i % n]), 
                // agar wo 1 tha to use current count se ghata denge.
                currCount -= nums[i % n];
                i++; // Pichle pointer ko ek step aage badhao
            }

            // 4. Har step par check karo ki kya is window mein ab tak ke sabse zyada 1's mile hain?
            maxCount = Math.max(maxCount, currCount);
            
            // Aage wale pointer ko badhao taaki window aage slide kare
            j++;
        }

        // 5. Final Answer: Hamein jitne total 1's chahiye the (countOnes), 
        // usme se minus kar do jo kisi window mein pehle se sath mein baithe hain (maxCount).
        // Bache hue 1's ko hi swap karke andar lana padega.
        return countOnes - maxCount;
    }

}
