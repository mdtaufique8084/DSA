class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg=Double.NEGATIVE_INFINITY;
        int n=nums.length;
        int left=0,right=0;
        double currSum=0;
        while(right<n){
            currSum+=nums[right];
            int window=right-left+1;
            if(window==k){
                maxAvg=Math.max(maxAvg,currSum/k);
                currSum-=nums[left];
                left++;
            }
            right++;
        }
        return maxAvg;
    }
}