class Solution {
    public String largestGoodInteger(String num) {
        char max = ' ';
        int n = num.length();
        for (int i = 0; i < n; i++) {
            char ch1 = num.charAt(i);
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                char ch2 = num.charAt(j);
                if (ch1 != ch2) {
                    break;
                } else {
                    count++;
                }
                if (count == 3) {
                    if (ch1 > max) {
                        max = ch1;
                    }
                }
            }
        }
        if(max==' '){
            return "";
        }
        String res = "";
        for (int i = 0; i < 3; i++) {
            res += max;
        }
        return res;
    }
}
