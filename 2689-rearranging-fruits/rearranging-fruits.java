class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> map=new HashMap<>(); // to store the freq of each cost in both array

        // to stre freq of basket1 el n +ve order
        int min=Integer.MAX_VALUE; // min swap is better then one to one swap
        for(int el1:basket1){
            map.put(el1,map.getOrDefault(el1,0)+1);
            min=Math.min(min,el1);
        }
        
        // to check the freq of el which is extra can be 0,+ve,-ve
        for(int el2:basket2){
            map.put(el2,map.getOrDefault(el2,0)-1);
            min=Math.min(el2,min);
        }

        List<Integer> extra=new ArrayList<>(); // to store freq/2 element of map

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int cost=entry.getKey();
            int count=entry.getValue();

            if(count==0){ // this el is in good position ,no swap needed 
                continue;
            }

            if(count%2==1){ // cant be swap to make array equal ,both array now can be equal
                return -1;
            }

            for(int c=1;c<=Math.abs(count)/2;c++){ // until to list only freq/2 time the cost
                extra.add(cost);
            }
        }

        long result=0;
        Collections.sort(extra);

        for(int i=0;i<extra.size()/2;i++){
            result+=Math.min(extra.get(i),2*min); // min swap comparision and one to one swap
        }
        return result;
    }
}