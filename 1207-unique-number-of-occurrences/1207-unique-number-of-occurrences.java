class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Store frequency of each number
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int freq : map.values()) {
            if (set.contains(freq)) {
                return false;
            }
            set.add(freq);
        }
        
        return true;
    }
}
