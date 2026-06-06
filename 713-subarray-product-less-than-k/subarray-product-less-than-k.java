class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int l = 0; l < n; l++) {
            long product = 1;
            for (int r = l; r < n; r++) {
                product *= nums[r];
                if (product < k) {
                    count++;
                }
                else {
                    break;
                }
            }
        }
        return count;
    }
}