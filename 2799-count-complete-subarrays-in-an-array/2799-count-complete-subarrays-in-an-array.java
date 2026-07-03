class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int totalDistinct = new HashSet<>(Arrays.stream(nums).boxed().toList()).size();

        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, result = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() == totalDistinct) {
                result += (n - j);
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
        return result;
    }
}
