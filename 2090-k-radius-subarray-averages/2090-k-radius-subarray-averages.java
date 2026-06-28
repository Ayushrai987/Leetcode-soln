import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avgs = new int[n];
        
        // Sabse pehle poore array mein -1 bhar dete hain
        Arrays.fill(avgs, -1);
        
        // Ek valid window ki size 2*k + 1 hoti hai
        int windowSize = 2 * k + 1;
        
        // Agar array ki length hi window size se choti hai, toh kahi bhi average nahi nikal payega
        if (n < windowSize) {
            return avgs;
        }
        
        long windowSum = 0;
        
        // Step 1: Pehli window (0 se leke 2*k tak) ka sum nikal lo
        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }
        
        // Pehli window ka center index 'k' par hoga
        avgs[k] = (int) (windowSum / windowSize);
        
        // Step 2: Ab window ko aage slide karo
        // 'j' pointer naye element ko darshayega, aur hum left se purana element nikalenge
        for (int j = windowSize; j < n; j++) {
            // Naya element add kiya, aur leftmost element (j - windowSize) minus kiya
            windowSum += nums[j] - nums[j - windowSize];
            
            // Ab is window ka center index hoga: j - k
            avgs[j - k] = (int) (windowSum / windowSize);
        }
        
        return avgs;
    }
}