class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxL = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];   // reset for every start index

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                // Inline balanced check (instead of helper)
                int common = 0;
                boolean balanced = true;

                for (int f : freq) {
                    if (f == 0) continue;

                    if (common == 0) {
                        common = f;   // baseline frequency
                    } else if (f != common) {
                        balanced = false;
                        break;
                    }
                }

                if (balanced) {
                    maxL = Math.max(maxL, j - i + 1);
                }
            }
        }

        return maxL;
    }
}
