class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        // adding into map according to val of r-c 
        Map<Integer,List<Integer>> diagonals=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int key=i-j;
                diagonals.putIfAbsent(key,new ArrayList<>());
                diagonals.get(key).add(grid[i][j]);
            }
        }

        // sort it ,if r-c>=0 deceasing order ,else increasing order
        for(Map.Entry<Integer,List<Integer>> entry:diagonals.entrySet()){
            List<Integer> diag=entry.getValue();
            if(entry.getKey()>=0){
                diag.sort(Collections.reverseOrder());
            }
            else{
                Collections.sort(diag);
            }
        }

        // restore into the grid
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int key=i-j;
                List<Integer> diag=diagonals.get(key);
                grid[i][j]=diag.remove(0);
            }
        }
        return grid;
    }
}