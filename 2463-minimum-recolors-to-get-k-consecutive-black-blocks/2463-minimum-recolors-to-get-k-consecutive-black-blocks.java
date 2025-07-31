class Solution {
    public int minimumRecolors(String s, int k) {
        int i=0;
        int j=0;
        int ans=k;
        int wc=0;
        while(j<s.length()){
            if(s.charAt(j)=='W'){
                wc++;
            }
            if(j-i+1==k){
                ans=Math.min(ans,wc);
                if(s.charAt(i)=='W'){
                    wc--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}