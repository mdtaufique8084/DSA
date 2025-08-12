class Solution {
    int[][] dp;
    int mod=(int)(1e9+7);
    public int numberOfWays(int n, int x) {
        dp=new int[n+1][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(1,n,n,x);
    }
    private int solve(int st,int n,int sum,int x){
        if(sum==0){
            return 1;
        }
        if(st>n){
            return 0;
        }
        if(sum<0){
            return 0;
        }
        if(dp[st][sum]!=-1){
            return dp[st][sum];
        }
        int curr=(int)Math.pow(st,x);
        int take=solve(st+1,n,sum-curr,x);
        int skip=solve(st+1,n,sum,x);
        dp[st][sum] = (int)(((long)take+skip)%mod);
        return dp[st][sum];
    }
}