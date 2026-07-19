class Solution {
    public boolean canReach(int[] start, int[] target) {
        int st = (start[0] + start[1]) % 2;
        int tg = (target[0] + target[1]) % 2;

        return st == tg;
    }
}