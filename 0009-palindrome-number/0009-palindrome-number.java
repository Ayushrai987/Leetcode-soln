class Solution {
    public boolean isPalindrome(int x) {
      
     if(x<0) return false;
        int revnum =0;
        int dub = x;
        while (x>0){
            int Ld = (int)(x%10);
            revnum =  (revnum*10)+Ld ;
            x= x/10;
        }
        if (dub==revnum){
            System.out.println("true");
        }
        return dub == revnum;
    }
}
       
    

