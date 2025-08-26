class Solution {
    public int areaOfMaxDiagonal(int[][] dim) {
        int idx=0;
        int n=dim.length;
        int maxDiag=0;
        int maxArea=0;
        for(int i=0;i<n;i++){
            int l=dim[i][0];
            int w=dim[i][1];
            int diag=l*l+w*w;
            int area=l*w;
            if(diag>maxDiag){
                maxDiag=diag;
                maxArea=area;
            }
            else if(diag==maxDiag && area>maxArea){
                maxArea=area;
            }
        }
        return maxArea;
    }
}