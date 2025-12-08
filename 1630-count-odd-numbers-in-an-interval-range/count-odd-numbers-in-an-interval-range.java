class Solution {
    public int countOdds(int low, int high) {
        int val=(high-low)/2;
        if(low%2==0 && high%2==0){
            return val;
        }
        return val+1;
    }
}