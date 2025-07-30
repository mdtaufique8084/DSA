class Solution {
    public String longestNiceSubstring(String s) {
        String res="";
        int len=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String sub=s.substring(i,j);
                if(isTrue(sub) && res.length()<sub.length()){
                    res=sub;
                }
            }
        }
        return res;
    }

    private boolean isTrue(String s){
        Set<Character> lower=new HashSet<>();
        Set<Character> upper=new HashSet<>();

        for(char ch:s.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower.add(ch);
            }
            else{
                upper.add(ch);
            }
        }

        for(char ch='a';ch<='z';ch++){
            if(lower.contains(ch) || upper.contains(Character.toUpperCase(ch))){
                if(!(lower.contains(ch) && upper.contains(Character.toUpperCase(ch)))){
                    return false;
                }
            }
        }
        return true;
    }
}