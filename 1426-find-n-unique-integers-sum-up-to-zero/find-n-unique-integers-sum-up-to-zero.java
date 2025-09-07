class Solution {
    public int[] sumZero(int n) {
        int[] res=new int[n];
        int el=1;
        int i=0;
        while(i+1<n){
            res[i]=el;
            res[i+1]=-el;
            el++;
            i=i+2;
        }
        return res;
    }
}