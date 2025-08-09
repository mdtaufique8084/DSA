class Solution {
    public double soupServings(int n) {
        if(n>=5000) return 1.0;
        double[][] serve = {
            {100, 0}, {75, 25}, {50, 50}, {25, 75}
        };
        double[][] dp=new double[n+1][n+1];
        for(double d[]:dp){
            Arrays.fill(d,-1.0);
        }
        return solve(n, n, serve,dp);
    }

    private double solve(int a, int b, double[][] serve,double[][] dp) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }
        if(dp[a][b]!=-1.0){
            return dp[a][b];
        }
        double probability = 0.0;
        for (double[] ser : serve) {
            int a_s = (int) ser[0];
            int b_s = (int) ser[1];
            probability += 0.25 * solve(a - a_s, b - b_s, serve,dp);
        }
        return dp[a][b]= probability;
    }
}
