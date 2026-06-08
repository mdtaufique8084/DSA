class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='#' && !s1.isEmpty()){
                s1.deleteCharAt(s1.length()-1);
            }
            if(ch!='#'){
                s1.append(ch);
            }
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(ch=='#' && !s2.isEmpty()){
                s2.deleteCharAt(s2.length()-1);
            }
            if(ch!='#'){
                s2.append(ch);
            }
        }
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        return s1.toString().equals(s2.toString());
    }
}