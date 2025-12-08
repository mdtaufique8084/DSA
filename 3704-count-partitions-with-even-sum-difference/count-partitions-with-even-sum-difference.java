class Solution {
    public int countPartitions(int[] nums) {
        int count=0;
        int n=nums.length;
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        int currSum=0;
        for(int i=0;i<n-1;i++){
            currSum+=nums[i];
            int remainSum=totalSum-currSum;
            if(Math.abs(remainSum-currSum)%2==0){
                count++;
            }
        }
        return count;
    }
}