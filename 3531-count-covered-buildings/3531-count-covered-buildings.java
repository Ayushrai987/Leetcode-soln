class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        //same y -> x-i,y    x,y       x+i,y
        //same x -> x,y-j    x,y       x,y+j
        int[] minRow = new int[n+1];
        int[] maxRow = new int[n+1];
        int[] minCol = new int[n+1];
        int[] maxCol = new int[n+1];

        Arrays.fill(minRow,n+1);
        Arrays.fill(minCol,n+1);

        for(int[]p: buildings){
            int x = p[0];
            int y = p[1];
            minRow[y]=Math.min(minRow[y],x);
            maxRow[y]=Math.max(maxRow[y],x);
            minCol[x]=Math.min(minCol[x],y);
            maxCol[x]=Math.max(maxCol[x],y);
        }

        int res=0;
        for(int[] p: buildings){
            int x=p[0];
            int y=p[1];
            if(x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x])
            res++;
        }
        return res;
    }
}