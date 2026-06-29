import java.util.HashMap;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int maxLen = 0;
        int left = 0;
        int maxFreq = 0;
        
        // Ek HashMap banaya characters ka count rakhne ke liye
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char rightChar = answerKey.charAt(right);
            
            // Current character ka count map mein badhao
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            
            // Max frequency ko update karo
            maxFreq = Math.max(maxFreq, map.get(rightChar));
            
            // Agar required flips 'k' se zyada ho gaye, toh window choti karo
            if ((right - left + 1) - maxFreq > k) {
                char leftChar = answerKey.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1); // Left character ka count kam karo
                left++; // Left pointer ko aage badhao
            }
            
            // Max length update karo
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}