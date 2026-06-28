class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        // Step 1: Pehle saare ke saare 'k' cards bilkul left se le lo
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += cardPoints[i];
        }
        
        int maxScore = currentSum;
        
        // Step 2: Pointers set karo
        int leftPointer = k - 1;  // Left side ka sabse aakhri card jo humne liya hai
        int rightPointer = n - 1; // Right side ka sabse aakhri card (peeche se pehla)
        
        // Step 3: Ek-ek karke left se hatao aur right se jodo
        while (leftPointer >= 0) {
            currentSum -= cardPoints[leftPointer];  // Left se ek card hataya
            currentSum += cardPoints[rightPointer]; // Right se ek card joda
            
            maxScore = Math.max(maxScore, currentSum); // Max score update karo
            
            leftPointer--;  // Left pointer ko peeche khiskaya
            rightPointer--; // Right pointer ko bhi peeche khiskaya
        }
        
        return maxScore;
    }
}