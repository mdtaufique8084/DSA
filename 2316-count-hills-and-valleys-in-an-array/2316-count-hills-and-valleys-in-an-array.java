class Solution {
    public int countHillValley(int[] nums) {
        int n=nums.length;
        int i=0; // point to non equal neighbour on left side
        int j=1; // point to present point where comparision to j+1 will take palce
        int count=0;
        while(j+1<n){ // comparision should be till second last element
            
            // hill or valley condition checking
            if((nums[j]>nums[i] && nums[j]>nums[j+1]) || nums[j]<nums[i] && nums[j]<nums[j+1]){
                count++;
                i=j; // next left point
            }
            j++; // new present point
        }
        return count;
    }
}