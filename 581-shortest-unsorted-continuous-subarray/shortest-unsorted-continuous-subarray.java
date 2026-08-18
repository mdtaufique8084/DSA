class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;

        while(left+1<n && nums[left]<=nums[left+1]) left++;
        while(right-1>=0 && nums[right]>=nums[right-1]) right--;

        if(left==n-1) return 0;

        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=left;i<=right;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }

        // ab min and max ko uske shi jagah pahachana h
        while(left-1>=0 && nums[left-1]>min) left--;
        while(right+1<n && nums[right+1]<max) right++;

        return right-left+1;
    }
}