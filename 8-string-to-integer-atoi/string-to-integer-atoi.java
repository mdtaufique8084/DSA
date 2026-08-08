class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        int start=0;
        int signed=1;
        long res=0;

        while(start<n && s.charAt(start)==' '){
            start++;
        }

        if(start<n && s.charAt(start)=='+'){
            signed=1;
            start++;
        }
        else if (start<n && s.charAt(start)=='-'){
            signed=-1;
            start++;
        }

        for(int i=start;i<n;i++){
            char ch=s.charAt(i);
            if(ch<'0' || ch>'9') break;
            int digit=ch-'0';
            res=res*10+digit;
            if(signed==1 && res>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(signed==-1 && -res<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)(signed*res);
    }
}