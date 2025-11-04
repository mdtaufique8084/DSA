class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        int i=0;
        int pos=k-1;
        int idx=0;
        while(pos<n){
            Map<Integer,Integer> map=new HashMap<>();
            for(int j=i;j<=pos;j++){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
            PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>(
                (a,b)->{
                    if(a.getValue()!=b.getValue()){
                        return b.getValue()-a.getValue();
                    }
                    else{
                        return b.getKey()-a.getKey();
                    }
                }
            );
            maxHeap.addAll(map.entrySet());
            int sum=0;
            for(int m=0;m<x && !maxHeap.isEmpty();m++){
                Map.Entry<Integer,Integer> entry=maxHeap.poll();
                sum+=entry.getValue()*entry.getKey();
            }
            res[idx++]=sum;
            pos++;
            i++;
        }
        return res;
    }
}