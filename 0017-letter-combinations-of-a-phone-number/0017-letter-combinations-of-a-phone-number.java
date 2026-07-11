class Solution {
    // Array mapping sabse fast hoti hai kyunki isme Hash collision ya function call ka overhead nahi hota.
    // Memory access direct O(1) hai.
    private final String[] KEYPAD = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Edge case handling
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // StringBuilder mutable hota hai, isliye ye baar-baar nayi String create karke memory waste nahi karta
        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int index, String digits, StringBuilder current, List<String> result) {
        // Base Case: Jab ek valid combination poori length ka ban jaye
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Direct ASCII minus karke O(1) mein integer index nikalna
        int digitNum = digits.charAt(index) - '0'; 
        String letters = KEYPAD[digitNum];

        // Level-by-level choices explore karna
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));       // 1. Take
            backtrack(index + 1, digits, current, result); // 2. Move to next digit
            current.deleteCharAt(current.length() - 1); // 3. Undo (Backtrack)
        }
    }
}