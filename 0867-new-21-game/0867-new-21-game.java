class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] prob=new double[n+1];
        prob[0]=1;

        double currSum=k>0?1:0;
        for(int i=1;i<=n;i++){
            prob[i]=currSum/maxPts;
            if(i<k){
                currSum+=prob[i];
            }
            if(i-maxPts>=0 && i-maxPts<k){
               currSum-=prob[i-maxPts];
            }
        }
        double sum=0;
        for(int i=k;i<=n;i++){
            sum+=prob[i];
        }
        return sum;
    }
}