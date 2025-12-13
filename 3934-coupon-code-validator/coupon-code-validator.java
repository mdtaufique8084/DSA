class Solution {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<String[]> codes = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            String s = code[i];
            String bl = businessLine[i];

            // correct condition + businessLine validation
            if (!isValid(s) || !isActive[i] || !isValidBusiness(bl)) {
                continue;
            }

            codes.add(new String[]{bl, s});
        }

        // sorting
        for (int i = 0; i < codes.size(); i++) {
            for (int j = i + 1; j < codes.size(); j++) {

                String bl1 = codes.get(i)[0];
                String bl2 = codes.get(j)[0];

                //  businessLine priority + code sort
                if (order(bl1) > order(bl2) ||
                   (order(bl1) == order(bl2) &&
                    isGreater(codes.get(i)[1], codes.get(j)[1]))) {

                    String temp[] = codes.get(i);
                    codes.set(i, codes.get(j));
                    codes.set(j, temp);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (String arr[] : codes) {
            ans.add(arr[1]);
        }
        return ans;
    }

    private boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            boolean isLower = (ch >= 'a' && ch <= 'z');
            boolean isUpper = (ch >= 'A' && ch <= 'Z');
            boolean isDigit = (ch >= '0' && ch <= '9');
            boolean isUnderScore = (ch == '_');

            if (!(isLower || isUpper || isDigit || isUnderScore)) {
                return false;
            }
        }
        return true;
    }

    // businessLine validation
    private boolean isValidBusiness(String bl) {
        return bl.equals("electronics") ||
               bl.equals("grocery") ||
               bl.equals("pharmacy") ||
               bl.equals("restaurant");
    }

    // businessLine order
    private int order(String bl) {
        if (bl.equals("electronics")) return 0;
        if (bl.equals("grocery")) return 1;
        if (bl.equals("pharmacy")) return 2;
        return 3; // restaurant
    }

    private boolean isGreater(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) > s2.charAt(i);
            }
        }
        return s1.length() > s2.length();
    }
}
