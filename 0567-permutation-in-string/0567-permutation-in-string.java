/Approach-1 (Brute Force) - TLE
//T.C : O(n! * m)
//S.C : O(n)
class Solution {
    private int n; // s1 string ki total length ko track karne ke liye
    private boolean result; // Final answer save karne ke liye (true ya false)

    // Yeh hamara main function hai jo LeetCode call karega
    public boolean checkInclusion(String s1, String s2) {
        n = s1.length(); // s1 ki length nikal kar save kar li
        result = false;  // Shuruat mein result ko false maan liya
        
        // Asli khel yahan se shuru: index 0 se dhoondhna shuru karo
        solve(0, s1, s2);
        
        return result;   // Jo bhi final result mile use return kar do
    }

    // Yeh recursive function (solve) saare permutations banayega
    private void solve(int idx, String s1, String s2) {
        // --- BASE CASE ---
        // Agar idx badhte-badhte n ke barabar ho gaya, matlab ek permutation poora ban gaya!
        if (idx == n) {
            // Ab check karo: Kya yeh naya bana hua s1, s2 ke andar maujood hai?
            if (s2.contains(s1)) {
                result = true; // Agar mil gaya toh result ko true kar do
            }
            return; // Is raaste ka kaam khatam, ab piche lauto
        }

        // String ko char array mein badla kyunki Java mein String ke characters badle nahi ja sakte
        char[] charArray = s1.toCharArray(); 
        
        // LOOP: idx waale position par aage ke saare characters ko baari-baari lakar check karna
        for (int i = idx; i < n; i++) {
            
            // 1. CHOOSE (Swap): idx aur i waale character ki jagah aapas mein badli
            swap(charArray, idx, i);
            
            // Naye array se ek nayi string banayi taaki aage bhej sakein
            String newS1 = new String(charArray);
            
            // 2. EXPLORE (Recursion): Agle index (idx + 1) ko fix karne ke liye aage badho
            solve(idx + 1, newS1, s2);
            
            // 3. UNCHOOSE / BACKTRACK (Wapas Swap): Piche aate waqt character ko firse pehle jaisa kar do
            // Yeh isliye zaroori hai taaki jab loop agle character (i++) ke liye chale, toh string kharab na ho
            swap(charArray, idx, i);
            
            // EARLY EXIT: Agar kisi bhi raaste se answer mil chuka hai (result true ho gaya),
            // toh aage ke faltu combinations mat banao, wahin se laut jao
            if (result) {
                return;
            }
        }
    }

    // Do characters ko aapas mein badalne (swap) ka simple tarika
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

//Approach-2 (Using Sorting and Comparing) - ACCEPTED
//T.C : O((m-n) * nlogn)
//S.C : O(n)
import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(); // s1 ki length (Maan lo "ab" ke liye n = 2)
        int m = s2.length(); // s2 ki length (Maan lo "eidbaooo" ke liye m = 8)

        // EDGE CASE: Agar s1 ki length s2 se badi hai, toh s1 ka permutation 
        // s2 ke andar kabhi aa hi nahi sakta. Seedhe false bhej do.
        if (n > m) return false;

        // 1. Sabse pehle s1 ko char array mein badla aur use SORT kar diya
        char[] sortedS1 = s1.toCharArray();
        Arrays.sort(sortedS1); // "ab" sort hokar ['a', 'b'] hi rahega

        // 2. LOOP: s2 ke andar n-length (2-length) ke tukde kaatne ke liye loop chalaya
        // Yeh loop m - n (8 - 2 = 6) tak chalega, kyunki uske aage 2 aksharon ka tukda bachega hi nahi
        for (int i = 0; i <= m - n; i++) {
            
            // s2.substring(start, end) -> index 'i' se shuru karke lagatar n (2) akshar kaat liye
            // i=0 par "ei" milega, i=1 par "id" milega, i=3 par "ba" milega
            String temp = s2.substring(i, i + n);

            // 3. Is kaate hue tukde (temp) ko bhi char array mein badal kar SORT karo
            char[] sortedTemp = temp.toCharArray();
            Arrays.sort(sortedTemp);

            // 4. COMPARE: Kya hamara sorted tukda aur sorted s1 bilkul ek jaise hain?
            if (Arrays.equals(sortedTemp, sortedS1)) {
                return true; // Agar haan, toh sahi permutation mil gaya! Wahin se TRUE return kar do
            }
        }

        // Agar poora loop khatam ho gaya aur kahin bhi true nahi hua, matlab permutation nahi hai
        return false;
    }
}


//Approach-3 (Sliding Window) - ACCEPTED
//T.C : O(m+n)
//S.C : O(26)
class Solution {
    private int n; // s1 string ki total length ko track karne ke liye
    private boolean result; // Final answer save karne ke liye (true ya false)

    public boolean checkInclusion(String s1, String s2) {
        n = s1.length(); // s1 ki length nikal kar save kar li
        result = false;  // Shuruat mein result ko false maan liya
        
        // Index 0 se dhoondhna shuru karo
        solve(0, s1, s2);
        
        return result;   // Final result return karein
    }

    // Yeh recursive function saare permutations banayega
    private void solve(int idx, String s1, String s2) {
        // --- BASE CASE ---
        // Agar idx badhte-badhte n ke barabar ho gaya, matlab ek permutation poora ban gaya!
        if (idx == n) {
            // Check karo: Kya yeh naya s1, s2 ke andar maujood hai?
            if (s2.contains(s1)) {
                result = true; // Agar mil gaya toh result ko true kar do
            }
            return; // Piche lauto
        }

        // String ko char array mein badla kyunki Java mein String ke characters badle nahi ja sakte
        char[] charArray = s1.toCharArray(); 
        
        // LOOP: idx waale position par aage ke saare characters ko baari-baari lakar swap karna
        for (int i = idx; i < n; i++) {
            
            // 1. CHOOSE (Swap): idx aur i waale character ki jagah aapas mein badli
            swap(charArray, idx, i);
            
            // Naye array se ek nayi string banayi taaki aage bhej sakein
            String newS1 = new String(charArray);
            
            // 2. EXPLORE (Recursion): Agle index (idx + 1) ko fix karne ke liye aage badho
            solve(idx + 1, newS1, s2);
            
            // 3. UNCHOOSE / BACKTRACK (Wapas Swap): Piche aate waqt character ko firse pehle jaisa kar do
            swap(charArray, idx, i);
            
            // EARLY EXIT: Agar answer pehle hi mil chuka hai, toh aage ke combinations mat banao
            if (result) {
                return;
            }
        }
    }

    // Do characters ko aapas mein badalne (swap) ka function
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
