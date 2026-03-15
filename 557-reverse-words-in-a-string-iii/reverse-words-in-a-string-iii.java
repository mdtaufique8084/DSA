class Solution {
    public String reverseWords(String s) {
        int j = 0;
        StringBuilder sb = new StringBuilder();
        String temp = "";

        while (j < s.length()) {
            char ch = s.charAt(j);

             
            if (Character.isWhitespace(ch)) {
                sb.append(reverse(temp)).append(" ");
                temp = "";
            }
            else{
                temp += ch;
            }

            j++;
        }

        // handle last word
        if (!temp.isEmpty()) {
            sb.append(reverse(temp));
        }

        return sb.toString().trim();
    }

    private String reverse(String s) {
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            res += s.charAt(i);
        }
        return res;
    }
}