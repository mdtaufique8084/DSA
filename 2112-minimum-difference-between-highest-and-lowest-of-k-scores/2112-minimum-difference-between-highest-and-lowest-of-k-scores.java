class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int i=0;
        int j=k-1;
        int min=Integer.MAX_VALUE;
        while(j<n){
           int diff=nums[j]-nums[i];
           min=Math.min(min,diff);
           i++;
           j++;
        }
        return min;
    }
}