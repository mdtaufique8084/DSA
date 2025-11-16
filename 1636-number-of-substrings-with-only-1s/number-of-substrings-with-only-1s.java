class Solution {
    public int numSub(String s) {
        int n = s.length();
        long mod = 1000000007;
        long res = 0;
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            } 
            else {
                res = (res + (count * (count + 1) / 2) % mod) % mod;
                count = 0;
            }
        }
        if (count > 0) {
            res = (res + (count * (count + 1) / 2) % mod) % mod;
        }
        return (int) res;
    }
}
