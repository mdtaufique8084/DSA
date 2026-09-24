class Solution {

    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int n = nums.length;
        int left = 0, right = 0;
        int result = 0;
        long currSum = 0;

        while (right < n) {

            int target = nums[right];
            currSum += nums[right];

            long windowSum = (long)(right - left + 1) * target;
            long ops = windowSum - currSum;

            while (ops > k) {

                currSum -= nums[left];
                left++;

                ops = (long)(right - left + 1) * target - currSum;
            }

            result = Math.max(result, right - left + 1);

            right++;
        }

        return result;
    }
}