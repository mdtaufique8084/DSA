class Solution {
    public String reverseWords(String s) {
        String[] word=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<word.length;i++){
            word[i]=reverse(word[i]);
        }
        for(int i=0;i<word.length;i++){
            sb.append(word[i]).append(" ");
        }
        return sb.toString().trim();
    }
    private String reverse(String s){
        String res="";
        for(int i=s.length()-1;i>=0;i--){
            res+=s.charAt(i);
        }
        return res;
    }
}