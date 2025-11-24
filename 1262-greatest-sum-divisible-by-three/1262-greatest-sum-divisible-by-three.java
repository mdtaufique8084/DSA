class Solution {
    Integer[][] dp;

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][3];
        return solve(nums, 0, 0);
    }

    private int solve(int[] nums, int idx, int rem) {
        // BASE CASE
        if (idx == nums.length) {
            return rem == 0 ? 0 : Integer.MIN_VALUE;
        }

        if (dp[idx][rem] != null) {
            return dp[idx][rem];
        }

        // INCLUDE nums[idx]
        int take = nums[idx] + solve(nums, idx + 1, (rem + nums[idx] % 3) % 3);

        // SKIP nums[idx]
        int skip = solve(nums, idx + 1, rem);

        return dp[idx][rem] = Math.max(take, skip);
    }
}
