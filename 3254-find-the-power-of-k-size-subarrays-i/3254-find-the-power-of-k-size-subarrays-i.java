import java.util.Arrays;

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;

        // Total windows kitni banengi? (n - k + 1)
        // Utni hi size ka hum result array banayenge.
        int[] result = new int[n - k + 1];
        
        // Shuruat mein pure result array ko -1 se bhar dete hain.
        // Agar koi window condition satisfy nahi karegi, to wo apne aap -1 hi rahegi.
        java.util.Arrays.fill(result, -1);

        // 'count' track karega ki piche se kitne elements LALATAR (consecutive & sorted) hain.
        // Shuruat mein single element khud mein valid hota hai, isliye count = 1.
        int count = 1; 

        // 1. Pehli Window (Index 0 se k-1 tak) ko check karna
        // Hum loop index 1 se shuru kar rahe hain aur pichle element (i-1) se compare kar rahe hain.
        for (int i = 1; i < k; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++; // Agar lagatar badh raha hai (jaise 2 ke baad 3), to count badhao
            } else {
                count = 1; // Agar sequence kahin bhi toota, to count wapas 1 par reset
            }
        }

        // Agar pehli window ke saare elements valid hain, to count ki value 'k' ho chuki hogi.
        if (count == k) {
            result[0] = nums[k - 1]; // Sorted array ka aakhiri element hi sabse bada (max) hota hai
        }

        // Pointers for Sliding Window
        int i = 1; // result array ke agle index ko track karne ke liye
        int j = k; // nums array mein agli window ke naye element ko track karne ke liye

        // 2. Sliding Window Process (Baaki bachi saari windows ke liye)
        while (j < n) {
            // Naye element (j) ko uske pichle element (j-1) se compare karo
            if (nums[j] == nums[j - 1] + 1) {
                count++; // Agar lagatar hai to sequence count badhao
            } else {
                count = 1; // Sequence toot te hi count reset to 1
            }

            // Agar hamara consecutive sequence count 'k' se bada ya barabar hai,
            // iska matlab piche ke saare 'k' elements ek dam perfect sequence mein hain.
            if (count >= k) {
                result[i] = nums[j]; // Is window ka maximum element nums[j] hoga
            }

            // Dono pointers ko ek step aage badhao (Window Slide)
            i++;
            j++;
        }

        // Return the final result array
        return result;
    }
}