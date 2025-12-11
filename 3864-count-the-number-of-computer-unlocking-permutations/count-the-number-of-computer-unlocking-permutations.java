class Solution {
    int mod=1000000007;
    public int countPermutations(int[] nums) {
        int n=nums.length;
        int min=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<=min){
                return 0;
            }
        }
        return factorial(n-1);
    }
    private int factorial(int x){
        long ans = 1;
        for (int i = 1; i <= x; i++) {
            ans = (ans * i) % mod;
        }
        return (int) ans;
    }
}