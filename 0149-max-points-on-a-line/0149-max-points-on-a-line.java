import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 1;
        
        int result = 0;
        
        // Loop 1: Ek point ko Center (Anchor) maano
        for (int i = 0; i < n; i++) {
            // Har naye center ke liye ek naya map jo angles ka hisab rakhega
            Map<Double, Integer> mp = new HashMap<>();
            
            // Loop 2: Baki saare points ka angle is center se nikalen
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // Khud se angle nahi nikal sakte
                
                double dy = points[j][1] - points[i][1]; // y2 - y1
                double dx = points[j][0] - points[i][0]; // x2 - x1
                
                // Yeh function dy aur dx lekar unka exact angle (slope) de deta hai
                double slopeAngle = Math.atan2(dy, dx);
                
                // Map me us angle ka count badhao
                mp.put(slopeAngle, mp.getOrDefault(slopeAngle, 0) + 1);
            }
            
            // Map me se check karo kis angle par sabse zyada points mile
            for (int count : mp.values()) {
                // count + 1 kyunki center point ko bhi jodna hai
                result = Math.max(result, count + 1);
            }
        }
        return result;
    }
}