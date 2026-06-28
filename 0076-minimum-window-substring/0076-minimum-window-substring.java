// import java.util.HashMap;
// import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();

        // Agar t ki length s se badi hai, toh s ke andar t milna namumkin hai.
        if (t.length() > n) return ""; 

        // Ek HashMap banaya jo t ke characters aur unki frequency store karega.
        Map<Character, Integer> mp = new HashMap<>();

        // Is loop se humne t ke saare characters ki frequency map mein daal di.
        // Agar t = "ABC" hai, toh map banega: {A:1, B:1, C:1}
        for (char ch : t.toCharArray())
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

        // requiredCount batata hai ki humein s mein se t ke kitne characters aur dhoodhne hain.
        int requiredCount = t.length(); 
        
        // Sliding Window ke do pointers: i (shuruat) aur j (khatam)
        int i = 0, j = 0;

        // Minimum window ki size aur uski starting position track karne ke liye variables
        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;

        // Window ko aage badhane ke liye main loop (j pointer move karega)
        while (j < n) {
            char ch = s.charAt(j); // Right pointer 'j' par jo character hai use nikala

            // AGAR ye character t ka hissa hai (map mein hai) AUR iski frequency > 0 hai,
            // iska matlab humein ek kaam ka character mil gaya, toh requiredCount ko 1 kam kar do.
            if (mp.containsKey(ch) && mp.get(ch) > 0)
                requiredCount--;

            // Har baar jab hum kisi character ko window mein shaamil karte hain, 
            // toh map mein uski frequency ko 1 kam kar dete hain (chahe wo t mein ho ya na ho).
            mp.put(ch, mp.getOrDefault(ch, 0) - 1);

            // Jab requiredCount == 0 ho jaye, matlab current window [i...j] mein t ke saare characters aa chuke hain!
            while (requiredCount == 0) {
                
                // Current window ki length calculate karo
                int currWindowSize = j - i + 1;

                // Agar ye purani minWindowSize se choti hai, toh isko update kar do
                if (minWindowSize > currWindowSize) {
                    minWindowSize = currWindowSize;
                    start_i = i; // Best window ka starting index save kar liya
                }

                // Ab hum window ko left se chota (shrink) karenge taaki aur choti window mil sake.
                char startChar = s.charAt(i);
                
                // Kyunki hum 'i' wale character ko window se nikal rahe hain, 
                // toh map mein uski frequency ko wapas 1 se badha denge.
                mp.put(startChar, mp.getOrDefault(startChar, 0) + 1);

                // AGAR wo character t ka hissa tha AUR map mein uski frequency 0 se badi ho gayi,
                // iska matlab ab humari window mein us character ki kami ho gayi hai, 
                // toh requiredCount ko wapas badhana padega.
                if (mp.containsKey(startChar) && mp.get(startChar) > 0) {
                    requiredCount++;
                }

                i++; // Left pointer ko aage badhao (window shrink karo)
            }

            j++; // Right pointer ko aage badhao (window expand karo)
        }

        // Agar minWindowSize change hi nahi hui, matlab koi window nahi mili -> "" return karo.
        // Varna s ka substring nikal kar return kar do.
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);
    }
}