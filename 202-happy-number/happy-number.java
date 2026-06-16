class Solution {
    public boolean isHappy(int n) {
        int actualNo=n;
        if(n==1 || n==7) return true;
        if(n>1 && n<10) return false;
        while(n>9){
            n=squareOfDigit(n);
            if(n==1 || n==7) return true;
        }
        return false;
    }
    private int squareOfDigit(int n){
        int res=0;
        while(n!=0){
            int lastDigit=n%10;
            res+=lastDigit*lastDigit;
            n=n/10;
        }
        return res;
    }
}