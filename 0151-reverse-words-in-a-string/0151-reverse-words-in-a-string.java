1. - import java.util.StringTokenizer;  
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



2-
class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim leading/trailing spaces
        s = s.trim();

        // Step 2: Reverse the whole string
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        int n = sb.length();
        int i = 0;
        int l = 0, r = 0; // l = left pointer, r = right pointer

        while (i < n) {
            // Step 3: Traverse until space or end of string
            while (i < n && sb.charAt(i) != ' ') {
                sb.setCharAt(r++, sb.charAt(i++)); // copy characters forward
            }

            // Step 4: If we found a word, reverse it back
            if (l < r) {
                reverse(sb, l, r - 1); // helper function to reverse word
                sb.setCharAt(r++, ' '); // add space after word
                l = r; // move left pointer to next word start
            }

            i++; // keep moving forward
        }

        // Step 5: Remove last extra space
        return sb.substring(0, r - 1);
    }

    // Helper function to reverse characters between l and r
    private void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
    }
}

