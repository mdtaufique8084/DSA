class Solution {
    public int myAtoi(String s) {
        String temp = s.trim();
        if (temp.isEmpty()) return 0;

        StringBuilder sb = new StringBuilder();
        char st = temp.charAt(0);

        // accept only one sign or a digit
        if (st == '-' || st == '+' || Character.isDigit(st)) {
            sb.append(st);
        } else {
            return 0;
        }

        // build the number part
        for (int i = 1; i < temp.length(); i++) {
            char ch = temp.charAt(i);
            if (!Character.isDigit(ch)) break;
            sb.append(ch);
        }

        String result = sb.toString();

        // CASE: result is only "+" or "-"
        if (result.equals("+") || result.equals("-")) {
            return 0;
        }

        // manually accumulate to avoid overflow
        long num = 0;
        boolean neg = (result.charAt(0) == '-');
        int start = (result.charAt(0) == '+' || result.charAt(0) == '-') ? 1 : 0;

        for (int i = start; i < result.length(); i++) {
            int digit = result.charAt(i) - '0';

            // detect overflow before it happens
            if (!neg && (num > (long)Integer.MAX_VALUE/10 ||
                    (num == (long)Integer.MAX_VALUE/10 && digit > 7))) {
                return Integer.MAX_VALUE;
            }

            if (neg && (num > (long)Integer.MIN_VALUE/-10 ||
                    (num == (long)Integer.MIN_VALUE/-10 && digit > 8))) {
                return Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
        }

        return neg ? (int)-num : (int)num;
    }
}
