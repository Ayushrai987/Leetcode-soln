class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // If s1 is longer than s2, it cannot be a substring
        if (n > m) return false;

        // Sort the string s1
        char[] sortedS1 = s1.toCharArray();
        Arrays.sort(sortedS1);

        // Iterate over each substring of s2 of length equal to s1
        for (int i = 0; i <= m - n; i++) {
            // Extract a substring of length n from s2 starting at index i
            String temp = s2.substring(i, i + n);

            // Sort the substring
            char[] sortedTemp = temp.toCharArray();
            Arrays.sort(sortedTemp);

            // If the sorted substring matches the sorted s1, return true
            if (Arrays.equals(sortedTemp, sortedS1)) return true;
        }

        // No permutation found in s2
        return false;
    }
}