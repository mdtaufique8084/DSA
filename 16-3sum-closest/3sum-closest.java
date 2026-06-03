class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res= Integer.MAX_VALUE/2;
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int first=nums[i];
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=first+nums[left]+nums[right];
                if(Math.abs(sum-target)<Math.abs(res-target)){
                    res=sum;
                }
                if(sum==target){
                    return sum;
                }
                else if(sum>target){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return res;
    }
}