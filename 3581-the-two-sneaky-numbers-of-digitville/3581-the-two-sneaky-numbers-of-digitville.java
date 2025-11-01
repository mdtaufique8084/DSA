class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int idx=0;
        for(int key:map.keySet()){
            if(map.get(key)>1){
                res[idx++]=key;
            }
        }
        return res;
    }
}