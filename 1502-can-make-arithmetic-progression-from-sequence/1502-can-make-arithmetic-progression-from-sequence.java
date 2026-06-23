import java.util.*;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;

        // Step 1: put all elements in a HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // Step 2: find min and max
        int min_el = Arrays.stream(arr).min().getAsInt(); // a0
        int max_el = Arrays.stream(arr).max().getAsInt(); // a0 + (n-1)*d

        // Step 3: check if difference is valid
        if ((max_el - min_el) % (n - 1) != 0) {
            return false;
        }

        int d = (max_el - min_el) / (n - 1);

        // Step 4: verify all expected terms exist
        int i = 0;
        while (i < n) {
            int num = min_el + i * d;
            if (!set.contains(num)) {
                return false;
            }
            i++;
        }

        return true;
    }
}
