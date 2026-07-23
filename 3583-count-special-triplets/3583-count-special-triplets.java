class Solution {
    static final int M = (int)1e9 + 7;
    public int specialTriplets(int[] nums) {
        
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        int result = 0;

        for(int num : nums){
            rightMap.put(num, rightMap.getOrDefault(num, 0) +1);
        }
        for(int num : nums){
            rightMap.put(num, rightMap.get(num) - 1);

            int left = leftMap.getOrDefault(num*2, 0);
            int right = rightMap.getOrDefault(num*2, 0);

            long add= (1L * left * right) % M;
            result = (int)((result + add) % M);

            leftMap.put(num, leftMap.getOrDefault(num, 0) +1);
        }
        return result;
        
        
    }
}