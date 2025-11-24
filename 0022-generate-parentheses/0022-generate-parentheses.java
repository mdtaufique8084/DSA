class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve(new StringBuilder(),n);
        return res;
    }
    private void solve(StringBuilder sb,int n){
        if(sb.length()==2*n){
            if(isValid(sb.toString())){
                res.add(sb.toString());
            }
            return;
        }
        sb.append('(');
        solve(sb,n);
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        solve(sb,n);
        sb.deleteCharAt(sb.length()-1);
    }
    private boolean isValid(String str){
        int count=0;
        for(char ch:str.toCharArray()){
            if(ch=='('){
                count++;
            }
            else{
                count--;
            }
            if(count<0){
                return false;
            }
        }
        return count==0;
    }
}