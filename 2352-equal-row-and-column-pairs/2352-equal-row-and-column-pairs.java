import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> rowMap = new HashMap<>();
        
        // 1. Store each row and count its frequency
        for (int[] row : grid) {
            List<Integer> rowList = new ArrayList<>();
            for (int val : row) {
                rowList.add(val);
            }
            rowMap.put(rowList, rowMap.getOrDefault(rowList, 0) + 1);
        }
        
        int equalPairsCount = 0;
        
        // 2. Build each column and check if it matches any stored rows
        for (int col = 0; col < n; col++) {
            List<Integer> colList = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                colList.add(grid[row][col]);
            }
            // If the column exists in our row map, add its frequency to the total
            equalPairsCount += rowMap.getOrDefault(colList, 0);
        }
        
        return equalPairsCount;
    }
}