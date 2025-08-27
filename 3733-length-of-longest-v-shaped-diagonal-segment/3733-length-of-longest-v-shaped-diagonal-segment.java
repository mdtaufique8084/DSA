class Solution {
    int[][] directions={{1,1},{1,-1},{-1,-1},{-1,1}};
    int m,n;
    int[][][][] dp;
    public int lenOfVDiagonal(int[][] grid) {
        int res=0;
        m=grid.length;
        n=grid[0].length;
        dp=new int[m][n][4][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int d=0;d<4;d++){
                    for(int c=0;c<2;c++){
                        dp[i][j][d][c]=-1;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int d=0;d<4;d++){
                        res=Math.max(res,1+solve(i,j,1,grid,2,d));
                    }
                }
            }
        }
        return res;
    }
    private int solve(int i,int j,int canTurn,int[][] grid,int val,int d){
        int i1=i+directions[d][0];
        int j1=j+directions[d][1];
        if(i1<0 || i1>=m || j1<0 || j1>=n || grid[i1][j1]!=val){
            return 0;
        }
        if(dp[i1][j1][d][canTurn]!=-1){
            return dp[i1][j1][d][canTurn];
        }
        int nextVal=val==2 ? 0 : 2;
        int length=0;
        int keepMovingStraight=1+solve(i1,j1,canTurn,grid,nextVal,d);
        length=Math.max(length,keepMovingStraight);

        if(canTurn==1){
            int turnAround=Math.max(keepMovingStraight,1+solve(i1,j1,0,grid,nextVal,(d+1)%4));
            length=Math.max(length,turnAround);
        }
        return dp[i1][j1][d][canTurn] = length;
    }
}