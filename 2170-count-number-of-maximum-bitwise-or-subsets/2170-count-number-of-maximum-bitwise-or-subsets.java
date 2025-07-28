class Solution {
    int count=0;
    public int countMaxOrSubsets(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        for(int num:nums){
            arr.add(num);
        }
        int maxOr=maxOr(arr); // max or
        solve(0,new ArrayList<>(),nums,maxOr);
        return count;
    }
    // backtracking to generate all the subsets of nums
    private void solve(int idx,List<Integer> temp,int[] nums,int maxOr){
        if(idx==nums.length){
            int or=maxOr(temp);
            if(or==maxOr){
                count++;
            }
            return;
        }
        temp.add(nums[idx]);
        solve(idx+1,temp,nums,maxOr);
        temp.remove(temp.size()-1);
        solve(idx+1,temp,nums,maxOr);
    }
    private int maxOr(List<Integer> arr){
        int res=0;
        for(int num:arr){
            res|=num;
        }
        return res;
    }
}