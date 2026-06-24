import java.util.StringTokenizer;  
// StringTokenizer class ko import karna zaroori hai, ye string ko tokens (words) me todta hai

class Solution {
    public String reverseWords(String s) {
        // StringTokenizer object banaya, jo string ko space ke basis par todta hai
        StringTokenizer st = new StringTokenizer(s);

        // StringBuilder banaya jisme hum efficiently words add/insert karenge
        StringBuilder result = new StringBuilder();
        
        // Jab tak tokens bache hain, loop chalta rahega
        while (st.hasMoreTokens()) {
            // nextToken() ek ek word nikalta hai
            String token = st.nextToken();

            // Har naya word ko result ke starting me insert karte hain
            // Isse words reverse order me aa jaate hain
            result.insert(0, token + " ");
        }
        
        // toString() se StringBuilder ko normal String me convert karte hain
        // trim() se last me bachi extra space hata dete hain
        return result.toString().trim();
    }
}
