class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        HashSet<List<Integer>> set=new HashSet<>();
        for(int i=0;i<n-2;i++){
            int first=nums[i];
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sec=nums[left];
                int third=nums[right];
                int sum=first+sec+third;
                if(sum==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(first);
                    temp.add(sec);
                    temp.add(third);
                    set.add(temp);
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum>0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}


// [-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]