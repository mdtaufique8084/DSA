class Solution {
    private void validRoutes(int row,int col,int[][] grid){
        // up
        for(int i=row-1;i>=0;i--){
            if(grid[i][col]==3 || grid[i][col]==2){
                break;
            }
            else{
                grid[i][col]=1;
            }
        }

        // down

        for(int i=row+1;i<grid.length;i++){
            if(grid[i][col]==3 || grid[i][col]==2){
                break;
            }
            else{
                grid[i][col]=1;
            }
        }

        // left

        for(int j=col-1;j>=0;j--){
            if(grid[row][j]==3 || grid[row][j]==2){
                break;
            }
            else{
                grid[row][j]=1;
            }
        }

        // right

        for(int j=col+1;j<grid[0].length;j++){
            if(grid[row][j]==3 || grid[row][j]==2){
                break;
            }
            else{
                grid[row][j]=1;
            }
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid=new int[m][n];
        
        // guard position
        for(int[] guard:guards){
            int i=guard[0];
            int j=guard[1];
            grid[i][j]=2;
        }

        // wall position
        for(int[] wall:walls){
            int i=wall[0];
            int j=wall[1];
            grid[i][j]=3;
        }

        // routing guard way without routes;
        for(int[] guard:guards){
            int i=guard[0];
            int j=guard[1];
            validRoutes(i,j,grid);
        }

        int unguarded=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    unguarded++;
                }
            }
        }
        return unguarded;
    }
}