class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int l=0,r=0,n=nums.length;
        int pro=1,count=0;
        while(r<n){
           pro=pro*nums[r];
           while(pro>=k){
              pro=pro/nums[l];
              l++;
           }
           count+=r-l+1;
           r++;
        }
        return count;
    }
}