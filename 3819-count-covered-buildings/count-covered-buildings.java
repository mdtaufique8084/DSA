class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int count=0;
        Map<Integer,List<Integer>> rowOnly=new HashMap<>();
        Map<Integer,List<Integer>> colOnly=new HashMap<>();
        for(int[] b:buildings){
            int x=b[0],y=b[1];
            if(!rowOnly.containsKey(y)){
                rowOnly.put(y,new ArrayList<>());
            }
            rowOnly.get(y).add(x);
            if(!colOnly.containsKey(x)){
                colOnly.put(x,new ArrayList<>());
            }
            colOnly.get(x).add(y);
        }

        for(List<Integer> row:rowOnly.values()){
            Collections.sort(row);
        }
        for(List<Integer> col:colOnly.values()){
            Collections.sort(col);
        }

        for(int[] b:buildings){
            int x=b[0],y=b[1];
            List<Integer> sameRow=rowOnly.get(y);
            List<Integer> sameCol=colOnly.get(x);

            int rowIndex=Collections.binarySearch(sameRow,x);
            int colIndex=Collections.binarySearch(sameCol,y);
            boolean left=rowIndex>0;
            boolean right=rowIndex<sameRow.size()-1;
            boolean top=colIndex>0;
            boolean bottom=colIndex<sameCol.size()-1;
            if(left && right && top && bottom){
                count++;
            }
        }
        return count;
    }
}