class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n]; // Har query ke baad ka answer store karne ke liye array
        
        // colormp: Ye track rakhta hai ki kaunsa color kitni balls par laga hai (Color -> Uska Count)
        Map<Integer, Integer> colormp = new HashMap<>(); 
        
        // ballmp: Ye track rakhta hai ki kis ball par abhi kaunsa color laga hai (Ball -> Color)
        // Iska faida ye hai ki limit chahe 10^9 ho, ye memory limit exceed (MLE) nahi karega
        Map<Integer, Integer> ballmp = new HashMap<>(); 
        
        // Har ek query ko ek-ek karke process karenge
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];  // Kaunsi ball ko color karna hai
            int color = queries[i][1]; // Kaunsa naya color lagana hai
            
            // STEP 1: Check karo kya is ball par pehle se koi color laga hua hai?
            if (ballmp.containsKey(ball)) { 
                int prevColor = ballmp.get(ball); // Ball ka purana color pata karo
                
                // Kyunki hum color badal rahe hain, to purane color ka count 1 kam karna padega
                colormp.put(prevColor, colormp.get(prevColor) - 1);
                
                // Agar wo purana color ab kisi bhi ball par nahi bacha (count 0 ho gaya),
                // to use unique colors ki ginti se hatane ke liye map se remove kar do
                if (colormp.get(prevColor) == 0) {
                    colormp.remove(prevColor);
                }
            }
            
            // STEP 2: Ball par naya color apply karo
            ballmp.put(ball, color); // Ball to Color map ko update kiya
            
            // STEP 3: Naye color ka count map me badhao
            // Agar ye color pehle se tha to +1 kar do, nahi to 0 + 1 = 1 set kar do
            colormp.put(color, colormp.getOrDefault(color, 0) + 1);
            
            // STEP 4: Abhi total kitne unique colors hain?
            // colormp ka size hi hume batayega ki kitne colors ka count > 0 hai
            result[i] = colormp.size();
        }
        
        // Saari queries process karne ke baad final result array return kar do
        return result;
    }
}