class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int right=0;
        while(right<n && nums[right]<0){
            right++;
        }
        int left=right-1;
        int idx=0;
        while(left>=0 && right<n){
            int x=nums[left]*nums[left];
            int y=nums[right]*nums[right];
            if(x>=y){
                res[idx++]=y;
                right++;
            }
            else{
                res[idx++]=x;
                left--;
            }
        }

        while(left>=0){
            res[idx++]=nums[left]*nums[left];
            left--;
        }
        while(right<n){
            res[idx++]=nums[right]*nums[right];
            right++;
        }
        return res;
    }
}