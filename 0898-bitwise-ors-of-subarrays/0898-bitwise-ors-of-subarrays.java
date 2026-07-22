class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> prev = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for( int num : arr){
            for( int x : prev){
                int val = x | num;
                curr.add(val);
                result.add(val);
            }
            curr.add(num);
            result.add(num);

            prev = new HashSet<>(curr);
            curr.clear();
        }
        return result.size();
        
    }
}