class Solution {
    public boolean balanced(int num) {
        int[] freq = new int[10];
        while (num > 0) {
            int digit = num % 10;
            freq[digit]++;
            num /= 10;
        }
        for (int d = 0; d <= 9; d++) {
            if (freq[d] != 0 && freq[d] != d) {
                return false;
            }
        }
        return true;
    }

    public int nextBeautifulNumber(int n) {
        for (int num = n + 1; num <= 1224444; num++) {
            if (balanced(num)) {
                return num;
            }
        }
        return -1;
    }
}