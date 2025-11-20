class Solution {
    int mod=1000000007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long evenW=modPow(5,even);
        long oddW=modPow(4,odd);
        return (int)((evenW*oddW)%mod);
    }
    private long modPow(long b,long p){
        if(p==0) return 1;
        long half=modPow(b,p/2);
        if(p%2==0){
            return (half*half)%mod;
        }
        return (b*half*half)%mod;
    }
}