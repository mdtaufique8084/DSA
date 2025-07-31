class Solution {
    public int longestAlternatingSubarray(int[] nums, int th) {
        int max=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0 && nums[i]<=th){
                int count=1,j=i+1;
                while(j<n && Math.abs(nums[j]-nums[j-1])%2==1 && nums[j]<=th){
                    count++;
                    j++;
                }
                max=Math.max(max,count);
                i=j-1;
            }
        }
        return max;
    }
}