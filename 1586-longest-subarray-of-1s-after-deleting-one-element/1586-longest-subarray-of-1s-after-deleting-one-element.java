class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int zeros=0;
        int l=0,r=0,max=0;
        while(r<n){
            if(nums[r]==0){
                zeros++;
            }
            if(zeros>1){
                if(nums[l]==0){
                    zeros--;
                }
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max-1;
    }
}