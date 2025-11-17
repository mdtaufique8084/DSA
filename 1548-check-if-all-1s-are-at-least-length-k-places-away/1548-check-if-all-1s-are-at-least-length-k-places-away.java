class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        int st=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                st=i;
                break;
            }
        }
        for(int j=st+1;j<n;j++){
            if(nums[j]==1){
                if(j-st-1<k){
                    return false;
                }
                else{
                    st=j;
                }
            }
        }
        return true;
    }
}