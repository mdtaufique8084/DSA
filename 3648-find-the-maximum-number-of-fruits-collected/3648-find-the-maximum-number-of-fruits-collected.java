class Solution {
    int n;
    int[][] dp;
    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        dp=new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }

        int sum1 = solve1(0,fruits);
        int sum2 = solve2(0, n - 1, fruits);
        int sum3 = solve3(n - 1, 0, fruits);
        return sum1 + sum2 + sum3;
    }

    private int solve1(int i, int[][] fruits) {
        int res = 0;
        for (i = 0; i < n; i++) {
            res += fruits[i][i];
            fruits[i][i]=0;
            dp[i][i]=0;
        }
        return res;
    }

    private int solve2(int i, int j, int[][] fruits) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if(i==n-1 && j==n-1){
            return 0;
        }
        if(i==j || i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int p1 =solve2(i + 1, j - 1, fruits);
        int p2 =solve2(i + 1, j, fruits);
        int p3 =solve2(i + 1, j + 1, fruits);
        int result = fruits[i][j] + Math.max(p1, Math.max(p2, p3));
        return dp[i][j]=result;
    }

    private int solve3(int i, int j, int[][] fruits) {
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return 0;
        }
        if(i==n-1 && j==n-1){
            return 0;
        }
        if(i==j || j>i){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int p1 =solve3(i - 1, j + 1, fruits);
        int p2 =solve3(i, j + 1, fruits);
        int p3 =solve3(i + 1, j + 1, fruits);
        int result =fruits[i][j] +  Math.max(p1, Math.max(p2, p3));
        return dp[i][j]= result;
    }
}
