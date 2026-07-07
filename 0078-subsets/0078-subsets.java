class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Base Case: Agar hum array ke baahar nikal gaye, matlab ek valid subset ban gaya
        if (index == nums.length) {
            result.add(new ArrayList<>(current)); // current ki copy result me daal do
            return;
        }

        // 1. INCLUDE karne ka decision
        current.add(nums[index]); // Element ko daala
        generateSubsets(index + 1, nums, current, result); // Agle element par gaye

        // 2. EXCLUDE karne ka decision (Backtrack)
        current.remove(current.size() - 1); // Jo element daala tha use nikala
        generateSubsets(index + 1, nums, current, result); // Bina us element ke agle par gaye
    }
}