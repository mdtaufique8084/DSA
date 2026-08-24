class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int count=Integer.MAX_VALUE;
        int n=nums.length;
        int left=0,right=0;
        while(right<n){
            sum+=nums[right];
            while(sum>=target){
                count=Math.min(count,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}