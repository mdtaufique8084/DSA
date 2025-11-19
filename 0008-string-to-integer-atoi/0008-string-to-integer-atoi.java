class Solution {
    public int myAtoi(String s) {
        int start = 0;
        int signed = 1;
        int n = s.length();
        long result = 0; // use long to detect overflow

        // 1. Skip leading spaces
        while (start < n && s.charAt(start) == ' ') {
            start++;
        }

        // 2. Sign check
        if (start < n && s.charAt(start) == '+') {
            signed = 1;
            start++;
        } else if (start < n && s.charAt(start) == '-') {
            signed = -1;
            start++;
        }

        // 3. Convert digits
        for (int i = start; i < n; i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') break;

            int digit = ch - '0';
            result = result * 10 + digit;

            // 4. Clamp on overflow
            if (signed == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (signed == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int)(result * signed);
    }
}