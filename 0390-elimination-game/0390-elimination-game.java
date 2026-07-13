class Solution {
    public int lastRemaining(int n) {
        // Shuruat mein hamari list ka pehla number (head) 1 hoga
        int head = 1;
        // Do numbers ke beech ka gap (step) shuru mein 1 hoga (1, 2, 3...)
        int step = 1;
        // List mein abhi total kitne numbers bache hain
        int remaining = n;
        // Direction track karne ke liye (true = left to right, false = right to left)
        boolean leftToRight = true;

        // Jab tak list mein 1 se zyada number bache hain, game chalega
        while (remaining > 1) {
            // TRICK: Head kab-kab aage badhega (badlega)?
            if (leftToRight || remaining % 2 != 0) {
                head = head + step;
            }

            // Har round ke baad bache hue numbers aadhe ho jate hain
            remaining = remaining / 2;
            // Har round ke baad bache hue numbers ka gap double ho jata hai
            step = step * 2;
            // Direction badal do (left ka right, right ka left)
            leftToRight = !leftToRight;
        }

        // Jab aakhri ek number bachega, wahi hamara head hoga
        return head;
    }
}