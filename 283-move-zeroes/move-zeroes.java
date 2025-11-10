class Solution {
    public void moveZeroes(int[] nums) {
        int x=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                x=i;
                break;
            }
        }
        for(int i=x+1;i<n;i++){
            if(nums[i]!=0 && x>=0){
                int temp=nums[i];
                nums[i]=nums[x];
                nums[x]=temp;
                x++;
            }
        }
    }
}