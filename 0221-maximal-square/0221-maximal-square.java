class Solution {
    int[][] dp;
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        dp=new int[m+1][n+1];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int curr=solve(i,j,matrix,m,n);
                max=Math.max(max,curr);
            }
        }
        return max*max;
    }
    private int solve(int i,int j,char[][] matrix,int m,int n){
        if(i>=m || j>=n){
            return 0;
        }
        if(matrix[i][j]=='0'){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right=solve(i,j+1,matrix,m,n);
        int down=solve(i+1,j,matrix,m,n);
        int diagonal=solve(i+1,j+1,matrix,m,n);
        return dp[i][j] = 1+Math.min(right,Math.min(down,diagonal));
    }
}