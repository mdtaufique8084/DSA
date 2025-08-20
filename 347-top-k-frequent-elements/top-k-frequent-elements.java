class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer>[] bucket=new ArrayList[nums.length+1];
        for(int i=0;i<=nums.length;i++){
            bucket[i]=new ArrayList<>();
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int element=entry.getKey();
            int freq=entry.getValue();
            bucket[freq].add(element);
        }
        int[] res=new int[k];
        int idx=0;
        for(int i=nums.length;i>=0 && idx<k;i--){
            if(!bucket[i].isEmpty()){
                for(int el:bucket[i]){
                    res[idx++]=el;
                    if(idx==k) break;
                }
            }
        }
        return res;
    }
}