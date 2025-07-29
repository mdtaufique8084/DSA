class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int[] setBitIndex=new int[32];
        Arrays.fill(setBitIndex,-1);

        for(int i=n-1;i>=0;i--){
            int endIdx=i; // to store small idx where bit can be set
            for(int b=0;b<32;b++){
                if((nums[i]&(1<<b))==0){ // bit is not set
                    if(setBitIndex[b]!=-1){
                        endIdx=Math.max(endIdx,setBitIndex[b]);
                    }
                }
                else{
                    setBitIndex[b]=i;
                }
            }
            res[i]=endIdx-i+1;
        }
        return res;
    }
}