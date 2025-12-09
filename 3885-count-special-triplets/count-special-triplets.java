class Solution {
    public int specialTriplets(int[] nums) {
        int n=nums.length;
        long res=0;
        int mod=1000000007;
        HashMap<Integer,Long> right=new HashMap<>();
        HashMap<Integer,Long> left=new HashMap<>();
        for(int num:nums){
            right.put(num,right.getOrDefault(num,0L)+1);
        }
        for(int j=0;j<n;j++){
            right.put(nums[j],right.get(nums[j])-1);
            long leftCount=left.getOrDefault(2*nums[j],0L);
            long rightCount=right.getOrDefault(2*nums[j],0L);
            res=(res+(leftCount*rightCount)%mod)%mod;
            left.put(nums[j],left.getOrDefault(nums[j],0L)+1);
        }
        return (int)res;
    }
}