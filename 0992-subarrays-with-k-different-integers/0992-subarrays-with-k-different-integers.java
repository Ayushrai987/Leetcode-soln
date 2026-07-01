import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, res = 0;

        for (int j = 0; j < nums.length; j++) {
            // add/update frequency
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // shrink window if distinct > k
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            // count subarrays ending at j
            res += j - i + 1;
        }
        return res;
    }
}
