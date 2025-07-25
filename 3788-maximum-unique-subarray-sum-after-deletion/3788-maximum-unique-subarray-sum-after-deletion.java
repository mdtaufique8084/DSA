class Solution {
    public int maxSum(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int sum=0;
        int maxVal=Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key=entry.getKey();
            maxVal=Math.max(maxVal,key);
            if(key>=0){
              sum+=key;
            }
        }
        return maxVal<0 ? maxVal : sum;
    }
}