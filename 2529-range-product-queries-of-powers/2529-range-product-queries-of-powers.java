class Solution {
    int mod = (int)(1e9 + 7);
    public int[] productQueries(int n, int[][] queries) {
        List<Long> power = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        // collecting powers of 2 from binary representation of n
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) { // checking if ith bit is set
                power.add(1L << i);
            }
        }

        // answering each query
        for (int[] q : queries) {
            int st = q[0];
            int end = q[1];
            long product = 1;
            for (int i = st; i <= end; i++) {
                product = (product * power.get(i)) % mod;
            }
            res.add((int) product);
        }

        // convert list to array
        int ans[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
