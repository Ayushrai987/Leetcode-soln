class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[256];   // ASCII characters ke liye
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                freq[c]++;

                if (freq[c] > 1) {   // duplicate mila → break
                    break;
                }
                max = Math.max(max, j - i + 1); // longest length update
            }
        }
        return max;
    }
}
