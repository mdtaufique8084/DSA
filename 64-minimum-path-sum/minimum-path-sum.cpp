class Solution {
public:
    int t[201][201];
    int solve(int i,int j,int n,int m,vector<vector<int>>& grid){
        if(i>=n || j>=m){
            return INT_MAX;
        }
        if(t[i][j]!=-1){
            return t[i][j];
        }
        if(i==n-1 && j==m-1){
            return grid[i][j];
        }
        int right=solve(i,j+1,n,m,grid);
        int down=solve(i+1,j,n,m,grid);
        return t[i][j]= grid[i][j]+min(right,down);
    }
    int minPathSum(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        memset(t,-1,sizeof(t));
        return solve(0,0,n,m,grid);
    }
};