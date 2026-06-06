class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int count=0;
        int l=0,r=0,n=nums.length;
        int p=1;
        while(r<n){
            p=p*nums[r];
            while(p>=k){
                p=p/nums[l];
                l++;
            }
            count+=(r-l+1);
            r++;
        }
        return count;
    }
}