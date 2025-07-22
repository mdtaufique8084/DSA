class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int i=0,j=0;
        int maxSum=0;
        int[] map=new int[(int)1e4+1];
        Arrays.fill(map,-1);
        while(j<n){
            i=Math.max(i,map[nums[j]]+1);
            int jthSum=prefix[j];
            int ithSum=i-1<0?0:prefix[i-1];
            maxSum=Math.max(maxSum,jthSum-ithSum);
            map[nums[j]]=j;
            j++;
        }
        return maxSum;
    }
}