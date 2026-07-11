class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, k, n, new ArrayList<>(), result );
        return result;
    }
    private void helper(int start, int k, int target, List<Integer> current, List<List<Integer>> result) {
        

        if(current.size() == k){
            if( target == 0){
                result.add(new ArrayList<>(current));
            }
            return;
        } 
        if( target  <0){
            return;
        }
        for( int i= start; i <= 9; i++){
            current.add(i);
            helper(i + 1, k, target - i, current, result);
            
            // 3. Wapas aate waqt element ko nikala (Backtrack / Undo)
            current.remove(current.size() - 1);
        }
        

    }
}