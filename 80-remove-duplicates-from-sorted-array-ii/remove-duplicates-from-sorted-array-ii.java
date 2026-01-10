class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int idx=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int key=entry.getKey();
            int count=Math.min(entry.getValue(),2);
            for(int i=0;i<count;i++){
                nums[idx++]=key;
            }
        }
        Arrays.sort(nums,0,idx);
        return idx;
    }
}