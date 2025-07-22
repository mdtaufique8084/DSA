class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        int sum=nums[0];
        int maxSum=sum;
        set.add(nums[0]);
        int l=0;
        for(int r=1;r<n;r++){
            while(set.contains(nums[r])){
                sum-=nums[l];
                set.remove(nums[l]);
                l++;
            }
            set.add(nums[r]);
            sum+=nums[r];
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}