class Solution {
    public char kthCharacter(int k) {
        // Shuru mein hum max length 1 se start karenge aur k tak jayenge
        return findKth(1, k);
    }
    
    private char findKth(int length, int k) {
        // Base Case: Jab length 1 ho, toh string sirf "a" hoti hai
        if (k == 1) {
            return 'a';
        }
        
        // Agar k abhi ke length se bada hai, toh length ko double karte jao
        // Taaki hum sahi 'level' ya 'string size' tak pahunch sakein
        if (k > length) {
            return findKth(length * 2, k);
        }
        
        // Ek baar sahi level mil gaya, toh Half-Half logic lagao
        int half = length / 2;
        
        if (k <= half) {
            // Case 1: Agar k left half mein hai, toh ye pichle step jaisa hi hai
            return findKth(half, k);
        } else {
            // Case 2: Agar k right half mein hai, toh corresponding index par jao (k - half)
            // Aur jo bhi character wahan se mile, usme +1 (next character) kar do
            char ch = findKth(half, k - half);
            
            // Handle character wrap-around (agar 'z' ke baad wapas 'a' par aana ho)
            if (ch == 'z') return 'a';
            return (char) (ch + 1);
        }
    }
}