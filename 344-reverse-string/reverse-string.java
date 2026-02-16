class Solution {
    public void reverseString(char[] s) {
        int i=0,j=s.length-1;
        while(i<j){
            swap(i,j,s);
            i++;
            j--;
        }
    }
    private void swap(int a,int b,char[] s){
        char temp=s[a];
        s[a]=s[b];
        s[b]=temp;
    }
}