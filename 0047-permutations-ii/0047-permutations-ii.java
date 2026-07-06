class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Duplicates ko ek saath lane ke liye sort kiya
        
        // Ek array banaya track rakhne ke liye ki kaun sa number use ho chuka hai
        boolean[] used = new boolean[nums.length]; 
        
        solve(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void solve(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        // 1. BASE CASE: Jab saare numbers kurshiyon par baith gaye
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Answer save karlo
            return;
        }

        // 2. CHOICES: Har ek number ko baki bachi kurshi par bithane ki koshish karo
        for (int i = 0; i < nums.length; i++) {
            // Agar number pehle se use ho chuka hai, toh skip karo
            if (used[i]) continue;
            
            // UNIQUE CONDITION: Agar pichla number same tha aur wo abhi use nahi ho raha,
            // toh duplicate arrangements se bachne ke liye isko skip kar do.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // Decision: Number ko bitha do
            used[i] = true;
            current.add(nums[i]);

            // Recursion: Baaki kurshiyon ko bharo
            solve(result, current, nums, used);

            // Backtracking: Wapas aate waqt kurshi khaali karo (Purani halat mein aao)
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}