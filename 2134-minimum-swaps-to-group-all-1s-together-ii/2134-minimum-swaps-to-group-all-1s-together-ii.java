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