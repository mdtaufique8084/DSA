class Solution {
    public int findClosest(int x, int y, int z) {
        int p1=Math.abs(x-z);
        int p2=Math.abs(y-z);
        if(p1==p2) return 0;
        return p1<p2 ? 1 : 2;
    }
}