class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start =0;
        int end = rows*cols-1;

        boolean result = false;

        while(start <=end){
            int mid = start + (end-start)/2;

            int row = mid / cols;
            int col = mid % cols;

            int midValue = matrix[row][col];
            if(midValue == target){
                result = true;
                break;
            }
            else if (midValue < target){
                start = mid +1;

            }
            else {
                end =mid-1;
            }

        }
        return result;

    }
}