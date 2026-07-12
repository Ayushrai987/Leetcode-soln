class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // 1. Poore board par ek-ek karke har cell par jayenge
        // Kyuki word board ke kisi bhi kone se shuru ho sakta hai
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Agar pehla letter match ho gaya, toh wahan se dhoodhna shuru karo
                if (board[r][c] == word.charAt(0)) {
                    if (backtrack(board, word, r, c, 0)) {
                        return true; // Agar word mil gaya toh yahi se khush hoke return true
                    }
                }
            }
        }
        return false; // Agar poora board dekh liya aur nahi mila
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int index) {
        // Base Case 1: Agar humne word ke saare letters dhoodh liye hain
        if (index == word.length()) {
            return true;
        }

        // Base Case 2: Boundary Checks aur Galat Letter Check
        // Agar hum board se bahar nikal gaye YAA cell ka letter word ke letter se match nahi kiya
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        // 2. [TAKE / VISIT] - Is cell ko temporary block kar do taaki hum ispar wapas ghum kar na aayein
        char temp = board[r][c];
        board[r][c] = '#'; // Ek dummy character daal diya

        // 3. [MOVE] - Ab is cell ke charo taraf (Down, Up, Right, Left) agla letter dhoodho
        boolean found = backtrack(board, word, r + 1, c, index + 1) || // Down
                        backtrack(board, word, r - 1, c, index + 1) || // Up
                        backtrack(board, word, r, c + 1, index + 1) || // Right
                        backtrack(board, word, r, c - 1, index + 1);   // Left

        // 4. [UNDO / BACKTRACK] - Kaam khatam hone ke baad cell ko wapas purana letter de do
        board[r][c] = temp;

        return found; // Agar charo mein se kisi bhi ek taraf word mil gaya toh true return hoga
    }
}