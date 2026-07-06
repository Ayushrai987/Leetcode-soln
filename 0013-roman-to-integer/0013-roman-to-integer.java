class Solution {
    public int romanToInt(String s) {
        // Step 1: Map values
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        // Step 2: Traverse string
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));

            // Step 3: Check next character
            if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
                result -= value; // subtract case
            } else {
                result += value; // normal add case
            }
        }

        return result;
    }
}
