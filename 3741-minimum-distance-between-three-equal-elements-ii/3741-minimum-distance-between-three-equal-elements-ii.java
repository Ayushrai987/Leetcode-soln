class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        Map<Integer, Deque<Integer>> map = new HashMap<>();
        int result = n;

        for (int k = 0; k < n; k++) {
            map.putIfAbsent(nums[k], new ArrayDeque<>());
            Deque<Integer> dp =map.get(nums[k]);

            dp.addLast(k);
            if (dp.size()>3)dp.pollFirst();

            if (dp.size() ==  3) {
                int first = dp.peekFirst();
                int last = dp.peekLast();
                result = Math.min(result, last - first);
            }
        }

        return result == n ? -1 : 2*result;
    }
}