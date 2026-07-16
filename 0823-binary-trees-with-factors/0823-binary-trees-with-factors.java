import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long MOD = 1_000_000_007L;
        Arrays.sort(arr); // Step 1: Sort the array
        
        // Map to store: [number -> count of trees possible with this number as root]
        Map<Integer, Long> dp = new HashMap<>();
        
        long totalTrees = 0;
        
        for (int i = 0; i < arr.length; i++) {
            long currentCount = 1; // Base case: single node tree
            
            for (int j = 0; j < i; j++) {
                int left = arr[j];
                
                // If left is a factor of arr[i]
                if (arr[i] % left == 0) {
                    int right = arr[i] / left;
                    
                    // Check if the corresponding right factor exists in our DP map
                    if (dp.containsKey(right)) {
                        long combinations = (dp.get(left) * dp.get(right)) % MOD;
                        currentCount = (currentCount + combinations) % MOD;
                    }
                }
            }
            
            dp.put(arr[i], currentCount);
            totalTrees = (totalTrees + currentCount) % MOD;
        }
        
        return (int) totalTrees;
    }
}