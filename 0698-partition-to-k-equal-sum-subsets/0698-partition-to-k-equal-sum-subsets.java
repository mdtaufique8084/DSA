class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%k!=0) return false;
        int reqSum=sum/k;
        int[] visited=new int[nums.length];
        return solve(0,0,reqSum,k,nums,visited);
    }
    private boolean solve(int st,int currSum,int reqSum,int k,int[] nums,int[] visited){
        if(k==0) return true;
        if(currSum==reqSum){
            return solve(0,0,reqSum,k-1,nums,visited); // new bucket will be formed
        }
        for(int i=st;i<nums.length;i++){
            if(visited[i]==1 || currSum+nums[i]>reqSum) continue;
            visited[i]=1;
            if(solve(i+1,currSum+nums[i],reqSum,k,nums,visited)){ // if true from other bucket
                return true;
            }
            visited[i]=0;
        }
        return false;
    }
}