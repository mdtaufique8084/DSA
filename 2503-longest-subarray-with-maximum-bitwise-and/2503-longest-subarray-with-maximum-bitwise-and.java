class Solution {
    public int longestSubarray(int[] nums) {
        int maxCount=0;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            if(num>max){
                max=num;
            }
        }
        
        int currCount=0;
        for(int num:nums){
            if(num==max){
                currCount++;
                maxCount=Math.max(maxCount,currCount);
            }
            else{
                currCount=0;
            }
        }
        return maxCount;
    }
}