class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0) return -1;
        int rem=0;
        int len=0;
        while(true){
            rem=(rem*10+1)%k;
            len++;
            if(rem==0){
                return len;
            }
        }
    }
}