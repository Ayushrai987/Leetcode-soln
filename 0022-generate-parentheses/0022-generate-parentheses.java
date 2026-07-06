

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Shuruat mein: empty string "", open bache hain 'n', close bache hain 'n'
        solve(result, "", n, n);
        return result;
    }
    
    private void solve(List<String> result, String current_string, int open, int close) {
        // Base Case: Jab koi bracket na bache, matlab valid string taiyar hai
        if (open == 0 && close == 0) {
            result.add(current_string);
            return;
        }
        
        // Choice 1: Agar open brackets bache hain, toh '(' daal do
        if (open > 0) {
            solve(result, current_string + "(", open - 1, close);
        }
        
        // Choice 2: Agar bache hue close brackets, open se zyada hain, toh ')' daal do
        if (close > open) {
            solve(result, current_string + ")", open, close - 1);
        }
    }
}