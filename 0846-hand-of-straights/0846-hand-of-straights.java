import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Agar total cards groupSize se divisible nahi hain → impossible
        if (hand.length % groupSize != 0) return false;

        // Step 1: Sort hand
        Arrays.sort(hand);

        // Step 2: Frequency map banao
        Map<Integer, Integer> freq = new HashMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        // Step 3: Iterate sorted hand
        for (int card : hand) {
            // Agar current card already used ho chuka hai → skip
            if (freq.get(card) == 0) continue;

            // Ek new group start karo
            for (int i = 0; i < groupSize; i++) {
                int nextCard = card + i;

                // Agar required card missing hai → fail
                if (freq.getOrDefault(nextCard, 0) == 0) {
                    return false;
                }

                // Frequency reduce karo
                freq.put(nextCard, freq.get(nextCard) - 1);
            }
        }

        // Agar sab groups ban gaye → success
        return true;
    }
}
