class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder binary = new StringBuilder();
        
        // Step 1 & 2: Convert each char to 8-bit binary
        for (char c : s.toCharArray()) {
            String bin = Integer.toBinaryString(c);
            // Pad with leading zeros to make length 8
            while (bin.length() < 8) {
                bin = "0" + bin;
            }
            binary.append(bin);
        }
        
        // Step 3 & 4: Check palindrome
        String str = binary.toString();
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
