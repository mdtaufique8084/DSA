class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int left=0,right=0,n=s.length();
        int result=0,maxFreq=0;
        while(right<n){
            char ch=s.charAt(right);
            freq[ch-'A']++;
            maxFreq=Math.max(maxFreq,freq[ch-'A']);
            while((right-left+1)-maxFreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            result=Math.max(result,right-left+1);
            right++;
        }
        return result;
    }
}