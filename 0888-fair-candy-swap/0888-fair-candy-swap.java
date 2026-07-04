class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumAlice =0, sumBob =0;
        for(int a : aliceSizes) sumAlice +=a;
        for(int b : bobSizes) sumBob +=b;
        int diff = (sumAlice- sumBob)/2;
        Set<Integer> bobSet = new HashSet<>();
        for (int b : bobSizes) bobSet.add(b);
        for(int a : aliceSizes) {
            int needFromBob = a - diff;
            if(bobSet.contains(needFromBob)) {
                return new int[]{a, needFromBob};
            }
        }
        return new int[0];


        
    }
}