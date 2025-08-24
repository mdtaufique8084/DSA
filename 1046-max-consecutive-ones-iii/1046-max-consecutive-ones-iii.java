class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen=0;
        int n=nums.length;
        int zeros=0;
        int l=0;
        int r=0;
        while(r<n){
            if(nums[r]==0){
                zeros++;
            }
            if(zeros>k){
                if(nums[l]==0){
                    zeros--;
                }
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}