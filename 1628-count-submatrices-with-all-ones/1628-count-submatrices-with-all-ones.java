class Solution {
    public int numSubmat(int[][] mat) {
        int m=mat.length; // row
        int n=mat[0].length; // cols
        int count=0;
        for(int tr=0;tr<m;tr++){ // from tr=0 to tr=m
            int[] rowMask=new int[n];
            Arrays.fill(rowMask,1);
            for(int br=tr;br<m;br++){ // from br=tr to br=m
                // filling mask of all combination of row 1 to last
                for(int col=0;col<n;col++){
                    rowMask[col]=rowMask[col] & mat[br][col];
                }
                count+=countConecutiveOneSubarray(rowMask);
            }
        }
        return count;
    }
    private int countConecutiveOneSubarray(int[] nums){
        int ans=0;
        int count=0;
        for(int num:nums){
            if(num==1){
                count++;
                ans+=count;
            }
            else{
                count=0;
            }
        }
        return ans;
    }
}