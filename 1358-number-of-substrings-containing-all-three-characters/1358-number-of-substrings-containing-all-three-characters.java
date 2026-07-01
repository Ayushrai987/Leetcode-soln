class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3]; // freq of a,b,c
        int i = 0, res = 0;

        for (int j = 0; j < n; j++) {
            count[s.charAt(j) - 'a']++;

            // shrink until window has all 3 chars
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += n - j; // all substrings ending at j are valid
                count[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return res;
    }
}
