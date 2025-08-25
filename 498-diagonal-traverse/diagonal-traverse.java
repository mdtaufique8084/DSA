class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        // preparing map to store index sum from 0-> m+n-2 and matrix value corresponsing to index sum 
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum=i+j;
                if(!map.containsKey(sum)){
                    map.put(sum,new ArrayList<>());
                }
                map.get(sum).add(mat[i][j]);
            }
        }

        // preparing answer
        int[] res=new int[m*n];
        int idx=0;
        for(int sum=0;sum<=m+n-2;sum++){
            List<Integer> diagonal=map.get(sum); // diagonal el according to question
            if(sum%2==0){
                Collections.reverse(diagonal); // even sum element is in reverse order according to answer
            }
            for(int d:diagonal){
               res[idx++]=d;
            }
        }
        return res;
    }
} 