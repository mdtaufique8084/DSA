class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long valid =0;
        // list to store the piont i{1,2,3,4,5..} and its conflicting pair{1,2,3,4...} in the form of list<Integer>
        List<List<Integer>> conflictingPoinsts=new ArrayList<>();
        for(int i=0;i<=n;i++){
            conflictingPoinsts.add(new ArrayList<>());
        }
        for(int p[]:conflictingPairs){
            int a=Math.min(p[0],p[1]); // minimum value of each pair
            int b=Math.max(p[0],p[1]); // maximum value of each pair
            conflictingPoinsts.get(b).add(a); // add in the form of  [5->{2,3}..]
        }

        long[] extra=new long[n+1]; // extra array to store extra points if i remove a particular pair
        int max=0; // maximum pair point (optimal to remove it)
        int smax=0; // sec optimal to remove
        for(int end=1;end<=n;end++){
            for(int u:conflictingPoinsts.get(end)){
                if(u>=max){ // new conflicting point
                    smax=max;
                    max=u;
                }
                else if(u>smax){
                    smax=u;
                }
            }
            valid+=end-max; // valid subarrays
            extra[max]+=max-smax; // extra point if i remove this
        }
        long maxExtra=0; // maximum value of extra array becz we can remove only one point
        for(long val:extra){
            if(val>maxExtra){
                maxExtra=val;
            }
        }
        return valid+maxExtra; // final answer
    }
}