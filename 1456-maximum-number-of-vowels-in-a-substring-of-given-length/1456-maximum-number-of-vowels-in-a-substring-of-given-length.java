class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    
    public int maxVowels(String s, int k) {
        int n = s.length();
        
        int maxV = 0;
        int count = 0;
        int i = 0, j = 0;
        
        while (j < n) {
            // Add current character if it's a vowel
            if (isVowel(s.charAt(j))) {
                count++;
            }
            
            // If window size reaches k
            if (j - i + 1 == k) {
                maxV = Math.max(maxV, count);
                
                // Remove leftmost character if it's a vowel
                if (isVowel(s.charAt(i))) {
                    count--;
                }
                i++; // shrink window from left
            }
            
            j++; // expand window from right
        }
        
        return maxV;
    }
}
