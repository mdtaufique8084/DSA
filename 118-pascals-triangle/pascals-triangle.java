class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> pascal=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){ // first and last element
                    row.add(1);
                }
                else{
                    int val=pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j); // remaining elemenet
                    row.add(val);
                }
            }
            pascal.add(row);
        }
        return pascal;
    }
}