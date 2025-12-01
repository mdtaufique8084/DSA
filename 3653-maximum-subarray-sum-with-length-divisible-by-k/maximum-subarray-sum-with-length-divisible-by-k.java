class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long[] prefix=new long[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        long maxSum=Long.MIN_VALUE;
        for(int st=0;st<k;st++){
            long currSum=0;
            int i=st;
            while(i<n && i+k-1<n){
                int j=i+k-1;
                long subSum=prefix[j]-(i>0 ? prefix[i-1]:0);
                currSum=Math.max(subSum,currSum+subSum);
                maxSum=Math.max(maxSum,currSum);
                i=i+k;
            }
        }
        return maxSum;
    }
}