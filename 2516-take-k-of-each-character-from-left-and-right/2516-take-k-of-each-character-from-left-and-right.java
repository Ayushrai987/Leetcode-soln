class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] total = new int[3]; // total['a'-'a'], total['b'-'a'], total['c'-'a']
        
        // STEP 1: Poori string mein saare 'a', 'b', 'c' ka kul count nikalna
        for (char c : s.toCharArray()) {
            total[c - 'a']++;
        }
        
        // BASE CASE: Agar kisi bhi character ka total count hi k se kam hai, 
        // toh hum kabhi bhi left/right se k characters nahi nikal payenge.
        if (total[0] < k || total[1] < k || total[2] < k) {
            return -1;
        }
        
        // STEP 2: Decide karna ki beech ki window mein maximum kitne chhod sakte hain
        int maxA = total[0] - k;
        int maxB = total[1] - k;
        int maxC = total[2] - k;
        
        int left = 0;
        int maxWindow = 0;
        int[] currentWindow = new int[3]; // Window ke andar ka count track karne ke liye
        
        // STEP 3: Sliding Window chala kar sabse bada beech ka safe tukda dhoondhna
        for (int right = 0; right < n; right++) {
            // Naye character ko window mein shaamil karo
            currentWindow[s.charAt(right) - 'a']++;
            
            // AGAR LIMIT CROSS HUI: Matlab window ne bahar ke liye 'k' characters nahi chhode.
            // Toh left waale pointer ko tab tak aage badhao jab tak condition normal na ho jaye.
            while (currentWindow[0] > maxA || currentWindow[1] > maxB || currentWindow[2] > maxC) {
                currentWindow[s.charAt(left) - 'a']--;
                left++;
            }
            
            // Har step par sabse badi valid window ki length update karte raho
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        
        // STEP 4: Answer nikalna
        // Total characters mein se beech ka chhoda hua hissa minus kar do, 
        // bacha hua left aur right ka count mil jayega.
        return n - maxWindow;
    }
}