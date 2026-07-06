import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency for s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Decrease frequency for t
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false; // character not present in s
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c); // cleanup to keep map small
            }
        }

        // If map is empty → all counts balanced
        return map.isEmpty();
    }
}
