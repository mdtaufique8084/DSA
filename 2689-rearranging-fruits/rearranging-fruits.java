class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int el1:basket1){
            map.put(el1,map.getOrDefault(el1,0)+1);
            min=Math.min(min,el1);
        }

        for(int el2:basket2){
            map.put(el2,map.getOrDefault(el2,0)-1);
            min=Math.min(el2,min);
        }

        List<Integer> extra=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int cost=entry.getKey();
            int count=entry.getValue();

            if(count==0){
                continue;
            }

            if(count%2==1){
                return -1;
            }

            for(int c=1;c<=Math.abs(count)/2;c++){
                extra.add(cost);
            }
        }

        long result=0;
        Collections.sort(extra);

        for(int i=0;i<extra.size()/2;i++){
            result+=Math.min(extra.get(i),2*min);
        }
        return result;
    }
}