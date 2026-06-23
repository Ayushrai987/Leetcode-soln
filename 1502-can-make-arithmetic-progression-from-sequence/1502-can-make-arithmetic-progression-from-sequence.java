import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;

        // Step 1: sort array
        Arrays.sort(arr);

        // Step 2: find common difference
        int d = arr[1] - arr[0];

        // Step 3: check all consecutive differences
        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != d) {
                return false;
            }
        }

        return true;
    }
}
