class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put (c, freq.getOrDefault(c,0)+1);
        }
        StringBuilder result = new StringBuilder();
        while (!freq. isEmpty()){
            char maxChar = ' ';
            int maxCount =0;
        
        for(char c: freq.keySet()){
            if( freq.get(c) > maxCount){
                maxCount = freq.get(c);
                maxChar =c;
            }
        }
        for(int i=0; i<maxCount; i++){
            result.append(maxChar);
        }
        freq.remove(maxChar);
     

        
     }   
     return result.toString();
    }
}