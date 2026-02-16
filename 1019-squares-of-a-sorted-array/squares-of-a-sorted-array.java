class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int left=-1,right=-1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                break;
            }
            left++;
        }
        right=left+1;
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