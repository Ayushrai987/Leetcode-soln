class Solution {
    public boolean isPerfectSquare(int num) {
        
        boolean result = false;
        double squareRoot = Math.sqrt(num);
        if(num == squareRoot * squareRoot && squareRoot % 1 ==0){
            result = true;
        } else{
            result = false;
        }
        return result;
    }
}
    
