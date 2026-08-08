class Solution {
    public double myPow(double x, int n) {
        boolean isNeg=n<0;
        double res=1.0;
        long power=Math.abs((long)n);
        while(power>0){
            if(power%2==1){
                res=res*x;
            }
            x=x*x;
            power=power/2;
        }
        return isNeg?1/res : res;
    }
}