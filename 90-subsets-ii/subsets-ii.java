class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,new ArrayList<>(),res);
        return res;
    }
    private void solve(int i,int[] nums,List<Integer> temp,List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        solve(i+1,nums,temp,res);
        temp.remove(temp.size()-1);
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        solve(i+1,nums,temp,res);
    }
}