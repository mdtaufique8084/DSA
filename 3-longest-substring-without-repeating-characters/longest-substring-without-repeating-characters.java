class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int left=0,right=0,maxSize=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(right<n){
            char ch=s.charAt(right);
            while(map.containsKey(ch)){
                char temp=s.charAt(left);
                map.put(temp,map.get(temp)-1);
                if(map.get(temp)==0){
                    map.remove(temp);
                }
                left++;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxSize=Math.max(maxSize,right-left+1);
            right++;
        }
        return maxSize;
    }
}