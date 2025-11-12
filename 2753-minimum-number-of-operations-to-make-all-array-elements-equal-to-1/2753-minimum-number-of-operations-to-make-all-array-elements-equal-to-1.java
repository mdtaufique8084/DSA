class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int ones=0;
        for(int num:nums){
            if(num==1){
                ones++;
            }
        }
        if(ones>0) return n-ones;
        int minOp=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            int currHcf=nums[i];
            for(int j=i+1;j<n;j++){
                currHcf=gcd(currHcf,nums[j]);
                if(currHcf==1){
                    minOp=Math.min(minOp,j-i);
                    break;
                }
            }
        }
        if(minOp==Integer.MAX_VALUE) return -1;
        return n-1+minOp;
    }
    private int gcd(int a,int b){
        int res=Math.min(a,b);
        while(res>0){
            if(a%res==0 && b%res==0){
                break;
            }
            res--;
        }
        return res;
    }
}