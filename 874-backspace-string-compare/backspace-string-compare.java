class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skip_s = 0, skip_t = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skip_s++;
                    i--;
                } else if (skip_s > 0) {
                    skip_s--;
                    i--;
                } else {
                    break;
                }
            }
            while(j>=0){
                if(t.charAt(j)=='#'){
                    skip_t++;
                    j--;
                }
                else if(skip_t>0){
                    skip_t--;
                    j--;
                }
                else{
                    break;
                }
            }
            char ch1=i<0 ? '$' : s.charAt(i);
            char ch2=j<0 ? '$' : t.charAt(j);
            if(ch1!=ch2) return false;
            i--;
            j--;
        }
        return true;
    }
}