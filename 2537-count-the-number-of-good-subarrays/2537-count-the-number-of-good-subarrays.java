import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0; // i = left pointer, j = right pointer (Sliding Window)

        long result = 0; // Total valid (good) subarrays ka count store karega
        long pairs = 0;  // Current window mein kitne pairs hain, yeh batayega

        // HashMap: Yeh track rakhega ki kaunsa number window mein kitni baar (frequency) aaya hai
        // Key -> Number (e.g., 5), Value -> Frequency (e.g., 3 baar aaya)
        Map<Integer, Integer> map = new HashMap<>();

        // Right pointer 'j' ko array ke shuru se end tak chalayenge
        while (j < n) {
            
            // STEP 1: Naye element (nums[j]) ke aane se kitne naye pairs banenge?
            // Agar koi number pehle se 2 baar hai, toh naya teesra number un dono ke sath 2 naye pairs banayega.
            // Isiliye map.getOrDefault() se purani frequency nikal kar direct pairs mein jod rahe hain.
            pairs += map.getOrDefault(nums[j], 0);

            // STEP 2: Ab is naye element ka count HashMap mein +1 badha do
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // STEP 3: Agar hamare paas kam se kam 'k' pairs ho gaye hain (Condition Satisfied!)
            while (pairs >= k) {
                
                // AGAR WINDOW [i...j] VALID HAI, TOH USKE AAGE KE SARE SUBARRAYS BHI VALID HONGE!
                // Index 'j' se lekar array ke end tak total (n - j) elements bache hain.
                // Isiliye hum ek baar mein saare valid subarrays ko 'result' mein jod dete hain.
                result += (n - j);

                // STEP 4: Ab window ko left side se chota (shrink) karenge, yaani 'i' ko aage badhayenge
                // 'i' pointer jis number par hai, use window se bahar nikalna hai:
                
                // Pahle us number ka count map mein 1 kam karo
                map.put(nums[i], map.get(nums[i]) - 1);

                // Us number ke hatne se kitne pairs kam hue? 
                // Jitne bache hue same elements map mein hain, utne pairs kam ho jayenge.
                pairs -= map.get(nums[i]);

                // Left pointer ko ek kadam aage badhao
                i++;
            }

            // Right pointer ko agle element par le jao
            j++;
        }

        // Saare valid subarrays ka total count return karo
        return result;
    }
}