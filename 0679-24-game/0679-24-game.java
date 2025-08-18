class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums=new ArrayList<>();
        for(int card:cards){
            nums.add((double)card);
        }
        return solve(nums);
    }
    private boolean solve(List<Double> nums){
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) <= 0.1;
        }
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.size();j++){
                if(i==j) continue;
                List<Double> remaining=new ArrayList<>();
                for(int k=0;k<nums.size();k++){
                    if(k!=i && k!=j){
                        remaining.add(nums.get(k));
                    }
                }

                double a=nums.get(i);
                double b=nums.get(j);
                List<Double> possibility=new ArrayList<>();
                possibility.add(a+b);
                possibility.add(a-b);
                possibility.add(b-a);
                possibility.add(a*b);
                if(Math.abs(a)>0.0){
                    possibility.add(b/a);
                }
                if(Math.abs(b)>0.0){
                    possibility.add(a/b);
                }

                for(double val:possibility){
                    remaining.add(val); // do  
                    if(solve(remaining)) return true; // explore 
                    remaining.remove(remaining.size()-1); // undo
                }
            }
        }
        return false;
    }
}