class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFreq=1;
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=nums[i]+prefix[i-1];
        }
        for(int i=0;i<nums.length;i++){
            int currFreq=binarySearch(i,nums,k,prefix);
            maxFreq=Math.max(maxFreq,currFreq);
        }
        return maxFreq;
    }
    private int binarySearch(int target_idx,int[] nums,int k,int[] prefix){
        int n=nums.length;
        int left=0;
        int right=target_idx;
        int result=0;
        while(left<=right){
            int mid=(left+right)/2;
            int count=target_idx-mid+1;
            int windowSum=count*nums[target_idx];
            int originalSum=prefix[target_idx]-prefix[mid]+nums[mid];
            int ops=windowSum-originalSum;
            if(ops>k){
                left=mid+1;
            }
            else{
                result=mid;
                right=mid-1;
            }
        }
        return target_idx-result+1;
    }
}