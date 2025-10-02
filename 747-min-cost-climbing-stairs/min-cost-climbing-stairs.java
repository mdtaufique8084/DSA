class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        int cost1=solve(0,n,cost);
        int cost2=solve(1,n,cost);
        return Math.min(cost1,cost2);
    }
    private int solve(int st,int end,int[] cost){
        if(st>=end){
            return 0;
        }
        if(dp[st]!=-1){
            return dp[st];
        }
        int next=cost[st]+solve(st+1,end,cost);
        int nextNext=cost[st]+solve(st+2,end,cost);
        return dp[st]= Math.min(next,nextNext);
    }
}