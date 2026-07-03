class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;

    }
    private void backtrack( int[] candidates, int remaining, int start, List<Integer> path, List<List<Integer>> result) {
        if (remaining ==0){
            result.add(new ArrayList<>(path));
            return;
        }
        for ( int i= start; i< candidates.length; i++){
            int val =candidates[i];
            if (val > remaining) break;
            path.add(val);
            backtrack(candidates, remaining- val, i, path, result);
            path.remove(path.size()-1);
        }
    }
}