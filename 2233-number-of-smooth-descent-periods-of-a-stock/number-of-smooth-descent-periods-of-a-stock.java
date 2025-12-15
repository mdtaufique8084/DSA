class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int n = prices.length;
        long count = 1;
        for (int i = 1; i < n; i++) {
            if (prices[i-1] == prices[i] + 1) {
                count++;
            }
            else {
                ans+=(count)*(count+1)/2;
                count = 1;
            }
        }
        ans+=(count)*(count+1)/2;
        return ans;
    }
}