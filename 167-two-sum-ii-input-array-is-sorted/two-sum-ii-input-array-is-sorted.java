class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        int n=nums.length;
        int i=0,j=n-1;
        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum==target){
                res[0]=i+1;
                res[1]=j+1;
                return res;
            }
            else if(sum>target){
                j--;
            }
            else{
                i++;
            }
        }
        return res;
    }
}