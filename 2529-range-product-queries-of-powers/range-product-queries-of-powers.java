class Solution {
    static final int MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        String binary = binary(n);
        int size = binary.length();
        int len = bitCount(n);

        int[] power = new int[len];
        int idx = 0;
        for (int i = size - 1; i >= 0; i--) {
            char ch = binary.charAt(i);
            if (ch == '1') {
                power[idx] = modPow(2, size - 1 - i);
                idx++;
            }
        }

        int[] prefix = new int[len];
        prefix[0] = power[0] % MOD;
        for (int i = 1; i < len; i++) {
            prefix[i] = (int) ((long) prefix[i - 1] * power[i] % MOD);
        }

        int s = queries.length;
        int[] res = new int[s];
        int x = 0;
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            if (l == 0) {
                res[x++] = prefix[r];
            } else {
                long inv = modInverse(prefix[l - 1]);
                res[x++] = (int) (prefix[r] * inv % MOD);
            }
        }
        return res;
    }

    private String binary(int num) {
        String binary = "";
        int temp = num;
        while (temp > 0) {
            binary = (temp % 2) + binary;
            temp /= 2;
        }
        return binary;
    }

    private int bitCount(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }

    // Modular exponentiation
    private int modPow(int base, int exp) {
        long res = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * b) % MOD;
            b = (b * b) % MOD;
            exp >>= 1;
        }
        return (int) res;
    }

    // Modular inverse using Fermat's Little Theorem (MOD is prime)
    private long modInverse(int a) {
        return modPow(a, MOD - 2);
    }
}
