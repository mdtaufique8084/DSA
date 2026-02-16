class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        // int i=0,j=n-1;
        for(int i=0;i<n;i++){
           res[i]=nums[i]*nums[i];
        }
        Arrays.sort(res);
        return res;
    }
}