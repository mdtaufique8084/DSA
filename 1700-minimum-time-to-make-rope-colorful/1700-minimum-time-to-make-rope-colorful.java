class Solution {
    public int minCost(String colors, int[] needTime) {
        int minTime=0;
        int n=colors.length();
        int j=0;
        for(int i=1;i<n;i++){
            char curr=colors.charAt(i);
            char prev=colors.charAt(i-1);
            if(curr==prev){
                minTime+=Math.min(needTime[i],needTime[j]);
                if(needTime[i]>needTime[j]){
                    j=i;
                }
            }
            else{
                j=i;
            }
        }
        return minTime;
    }
}