class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;

        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, k, 0, 0, target, used);
    }

    private boolean backtrack(int[] nums, int k, int currSum, int start, int target, boolean[] used) {
        if (k == 0) return true;
        if (currSum == target) return backtrack(nums, k - 1, 0, 0, target, used);

        for (int i = start; i < nums.length; i++) {
            if (used[i] || currSum + nums[i] > target) continue;

            used[i] = true;
            if (backtrack(nums, k, currSum + nums[i], i + 1, target, used)) return true;
            used[i] = false;
        }
        return false;
    }
}
