class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int current_party = 0;
        int maxLength = 0;
        
        // right pointer se array ke har number par jayenge
        for (int right = 0; right < n; right++) {
            
            // 1. CLASH CHECK: Agar naye number ka bit aur purane kisi number ka bit match ho gaya
            while ((current_party & nums[right]) != 0) {
                // Toh left waale number ko party se nikalo
                // ^ (XOR) operator se hum us number ke bits ko remove kar dete hain
                current_party ^= nums[left];
                left++; // Window ko aage badhao
            }
            
            // 2. ADD TO PARTY: Naye number ko party mein shaamil karo
            // | (OR) operator se naye number ke bits current_party mein jud jaate hain
            current_party |= nums[right];
            
            // 3. MAX LENGTH UPDATE: Abhi tak ki sabse badi window track karo
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}