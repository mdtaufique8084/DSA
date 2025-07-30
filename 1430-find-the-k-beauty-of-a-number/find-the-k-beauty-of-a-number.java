class Solution {
    public int divisorSubstrings(int num, int k) {
        int count=0;
        int i=0;
        int j=k-1;
        String str = Integer.toString(num);
        int n=str.length();
        while(j<n){
            String sb=str.substring(i,j+1);
            int val=Integer.parseInt(sb);
            if(val!=0 && num%val==0){
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}