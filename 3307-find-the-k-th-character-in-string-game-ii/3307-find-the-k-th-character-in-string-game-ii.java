class Solution {
    public char kthCharacter(long k, int[] operations) {
        // Base Case: Agar K = 1 hai, toh shuruat hamesha 'a' se hi hoti hai
        if (k == 1) {
            return 'a';
        }

        // 1. Pata karo ki ye K kaunse step (operation) se paida hua hai
        int n = operations.length;
        long len = 1;
        int step = 0;

        // Hum tab tak string ki length double karte hain jab tak wo K tak na pahunch jaye
        while (len < k) {
            len *= 2;
            step++;
        }

        // Ab hume pata chal gaya ki is step par string ki total length 'len' hai
        long half = len / 2; // String ka aadha hissa
        int op = operations[step - 1]; // Is step par kaunsa operation chal raha tha

        // 2. REVERSE JUMP LOGIC (Peeche ki taraf koodna)
        if (k <= half) {
            // Agar K pehle se hi left wale aadhe hisse mein hai, toh seedhe peeche jao
            return kthCharacter(k, operations);
        } else {
            // Agar K right wale aadhe hisse mein hai, toh left mein jump maaro (k - half)
            char parentChar = kthCharacter(k - half, operations);
            
            // Agar operation 1 (Shift) tha, toh character ko 1 step aage badhao
            if (op == 1) {
                return parentChar == 'z' ? 'a' : (char)(parentChar + 1);
            }
            // Agar operation 0 (Copy) tha, toh jo piche character tha, wahi same rahega
            return parentChar;
        }
    }
}