class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        // prefix sum from left
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        
        int max = leftSum;
        int rightSum = 0;
        
        // try combinations: take i from right, (k-i) from left
        for (int i = 1; i <= k; i++) {
            rightSum += cardPoints[n - i];
            leftSum -= cardPoints[k - i];
            max = Math.max(max, leftSum + rightSum);
        }
        
        return max;
    }
}
