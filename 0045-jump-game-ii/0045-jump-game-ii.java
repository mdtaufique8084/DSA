class Solution {
    int[] dp;
    public int jump(int[] nums) {
        int n = nums.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0, n, nums);
    }

    private int solve(int st, int end, int[] nums) {
        if (st >= end - 1) {
            return 0;
        }
        if(dp[st]!=-1){
            return dp[st];
        }
        int ans = Integer.MAX_VALUE;
        int maxRange = nums[st];
        for (int i = 1; i <= maxRange && st + i < end; i++) {
            int sub = solve(st + i, end, nums);
            if (sub != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + sub);
            }
        }
        return  dp[st]=ans;
    }
}
