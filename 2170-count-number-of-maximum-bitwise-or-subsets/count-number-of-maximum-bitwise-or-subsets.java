class Solution {
    public int countMaxOrSubsets(int[] nums) {
        List<List<Integer>> subset=new ArrayList<>();
        solve(subset,0,new ArrayList<>(),nums);
        List<Integer> arr=new ArrayList<>();
        for(int num:nums){
            arr.add(num);
        }
        int xor=xor(arr);
        int res=0;
        for(List<Integer> sub:subset){
            if(xor(sub)==xor){
                res++;
            }
        }
        return res;
    }
    private void solve(List<List<Integer>> subset,int idx,List<Integer> temp,int[] nums){
        if(idx==nums.length){
            subset.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(subset,idx+1,temp,nums);
        temp.remove(temp.size()-1);
        solve(subset,idx+1,temp,nums);
    }
    private int xor(List<Integer> arr){
        int res=0;
        for(int num:arr){
            res|=num;
        }
        return res;
    }
}