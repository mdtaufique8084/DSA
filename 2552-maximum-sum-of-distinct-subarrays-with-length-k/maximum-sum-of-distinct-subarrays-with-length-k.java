class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0;
        long maxSum=0;
        int left=0;
        int right=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(right<nums.length){
            sum+=nums[right];
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            int window=right-left+1;
            if(window==k){
                if(map.size()==k){
                    maxSum=Math.max(maxSum,sum);
                }
                sum-=nums[left];
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            right++;
        }
        return maxSum;
    }
}