class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb=new StringBuilder(num+"");
        int max=num;
        int n=sb.length();
        for(int i=0;i<n;i++){
            StringBuilder temp=new StringBuilder(sb);
            char ch=sb.charAt(i);
            if(ch=='6'){
                temp.setCharAt(i,'9');
            }
            else{
                temp.setCharAt(i,'6');
            }
            int val=Integer.parseInt(temp.toString());
            max=Math.max(max,val);
        }
        return max;
    }
}