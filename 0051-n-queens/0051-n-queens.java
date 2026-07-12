class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        // 1. Pehle ek khali chess board banate hain '.' se bhara hua
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Row 0 se shuru karenge raniyo ko bithana
        backtrack(0, board, result);
        return result;
    }

    private void backtrack(int row, char[][] board, List<List<String>> result) {
        // Base Case: Agar hum saari rows (0 se n-1) par rani bitha chuke hain
        // Iska matlab hume ek sahi pattern mil gaya hai!
        if (row == board.length) {
            result.add(construct(board)); // Board ko String list mein convert karke result mein daalo
            return;
        }

        // Is current row mein, hum har column (chair) par baithne ka try karenge
        for (int col = 0; col < board.length; col++) {
            
            // SECURITY CHECK: Kya is row aur col par Rani bithana safe hai?
            if (isSafe(board, row, col)) {
                
                board[row][col] = 'Q'; // 1. TAKE: Rani bitha di
                
                backtrack(row + 1, board, result); // 2. MOVE: Agli row par rani bithane jao
                
                board[row][col] = '.'; // 3. UNDO: Wapas aate waqt rani hata di (Backtrack)
            }
        }
    }

    // Ye function check karta hai ki rani par koi attack toh nahi kar raha
    private boolean isSafe(char[][] board, int row, int col) {
        // 1. Upar waale saare rows mein same column check karo
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // 2. Left-Up Tircha (Diagonal) check karo
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // 3. Right-Up Tircha (Diagonal) check karo
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true; // Agar kahi se koi khatra nahi hai, toh safe hai!
    }

    // Board ko List<String> mein badalne ke liye chota sa helper function
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}