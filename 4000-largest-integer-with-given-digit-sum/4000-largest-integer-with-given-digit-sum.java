class Solution {
    public int largestInteger(int n, int s) {
        // Case 1: agar sum 0 hai
        if (s == 0) {
            return 0; // fix: hamesha 0 return karo
        }

        // Case 2: agar sum max possible se bada hai
        if (s > 9 * n) {
            return -1;
        }

        // Case 3: greedy fill
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int d = Math.min(9, s);
            ans.append(d);
            s -= d;
        }

        return Integer.parseInt(ans.toString());
    }
}
