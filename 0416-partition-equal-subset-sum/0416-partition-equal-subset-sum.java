class Solution {
    int n;
    int totalSum=0;
    int[][] dp;
    public boolean canPartition(int[] nums) {
        n=nums.length;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum%2==1){
            return false;
        }
        dp=new int[n][totalSum+1];
        for(int []d:dp){
            Arrays.fill(d,-1);
        }
        return solve(nums,0,0,totalSum/2);
    }
    private boolean solve(int[] nums,int idx,int currSum,int target){
        if(idx>=n || currSum>target) return false;
        if(currSum==target) return true;
        if (dp[idx][currSum] != -1) {
            return dp[idx][currSum] == 1;
        }
        boolean take=solve(nums,idx+1,currSum+nums[idx],target);
        boolean skip=solve(nums,idx+1,currSum,target);
        dp[idx][currSum]=(take || skip) ? 1 : 0;
        return take || skip;
    }
}