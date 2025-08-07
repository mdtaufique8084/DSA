class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n=fruits.length;
        int res=0;
        int[][] dp=new int[n][n];
        // child1 (i==j)
        for(int i=0;i<n;i++){
            res+=fruits[i][i];
        }
        
        // removing extra cell where incoming path is not allowed
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<j && i+j<n-1){
                    dp[i][j]=0;
                }
                else if(i>j && i+j<n-1){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=fruits[i][j];
                }
            }
        }

        // child 2 (i<j)
        for(int i=1;i<n;i++){
            for(int j=i+1;j<n;j++){
                int p1=dp[i-1][j-1];
                int p2=dp[i-1][j];
                int p3=j+1<n ? dp[i-1][j+1] : 0;
                dp[i][j]+=Math.max(p1,Math.max(p2,p3));
            }
        }

        // child 3 (i>j)
        for(int j=1;j<n;j++){
            for(int i=j+1;i<n;i++){
                int p1=dp[i-1][j-1];
                int p2=dp[i][j-1];
                int p3=i+1<n ? dp[i+1][j-1]:0;
                dp[i][j]+=Math.max(p1,Math.max(p2,p3));
            }
        }
        return res+dp[n-2][n-1] + dp[n-1][n-2];
    }
}