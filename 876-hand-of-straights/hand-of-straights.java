class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        if(nums.length%k!=0) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Arrays.sort(nums);
        for(int num:nums){
            if(!map.containsKey(num)) continue;
            for(int j=num;j<num+k;j++){
                int count=map.getOrDefault(j,0);
                if(count==0){
                    return false;
                }
                if(count==1){
                    map.remove(j);
                }
                else{
                    map.put(j,count-1);
                }
            }
        }
        return true;
    }
}