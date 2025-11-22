class Solution {
    public int minimumOperations(int[] nums) {
        int minOp=0;
        for(int num:nums){
            int sub=num-1;
            int add=num+1;
            if(sub%3==0 || add%3==0){
                minOp++;
            }
        }
        return minOp;
    }
}