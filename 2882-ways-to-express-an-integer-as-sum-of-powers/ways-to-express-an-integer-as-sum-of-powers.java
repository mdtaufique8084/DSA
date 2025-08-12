class Solution {
    int[][] dp;
    int mod=(int)(1e9+7);
    public int numberOfWays(int n, int x) {
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        int[] power=new int[n];
        for(int i=0;i<n;i++){
            power[i]=(int)Math.pow(arr[i],x);
        }
        dp=new int[n][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(0,n,power);
    }
    private int solve(int idx,int sum,int[] power){
        if(sum==0){
            return 1;
        }
        if(idx>=power.length){
            return 0;
        }
        if(sum<0){
            return 0;
        }
        if(dp[idx][sum]!=-1){
            return dp[idx][sum];
        }
        int take=solve(idx+1,sum-power[idx],power);
        int skip=solve(idx+1,sum,power);
        dp[idx][sum] = (int)(((long)take + skip) % mod);
        return dp[idx][sum];
    }
}