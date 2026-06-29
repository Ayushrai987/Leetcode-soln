class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int maxLen = 0;

        // CASE 1: 'T' ki sabse lambi chain dhoondo (F ko badal kar)
        int left = 0;
        int countFlips = 0;
        for (int right = 0; right < n; right++) {
            if (answerKey.charAt(right) == 'F') {
                countFlips++;
            }

            // Agar badlav 'k' se zyada ho gaye, toh left pointer ko aage badhao
            while (countFlips > k) {
                if (answerKey.charAt(left) == 'F') {
                    countFlips--;
                }
                left++;
            }

            // Window ki current length nikaalo aur max update karo
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // CASE 2: 'F' ki sabse lambi chain dhoondo (T ko badal kar)
        left = 0;
        countFlips = 0;
        for (int right = 0; right < n; right++) {
            if (answerKey.charAt(right) == 'T') {
                countFlips++;
            }

            // Agar badlav 'k' se zyada ho gaye, toh left pointer ko aage badhao
            while (countFlips > k) {
                if (answerKey.charAt(left) == 'T') {
                    countFlips--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}