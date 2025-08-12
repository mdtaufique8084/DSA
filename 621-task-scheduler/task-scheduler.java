class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add(freq[i]);
            }
        }
        int time=0;
        while(!pq.isEmpty()){
            List<Integer> list=new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                if(!pq.isEmpty()){
                    list.add(pq.poll()-1);
                }
            }
            for(int el:list){
                if(el>0){
                    pq.offer(el);
                }
            }
            if(pq.isEmpty()){
                time+=list.size();
            }
            else{
                time+=n+1;
            }
        }
        return time;
    }
}