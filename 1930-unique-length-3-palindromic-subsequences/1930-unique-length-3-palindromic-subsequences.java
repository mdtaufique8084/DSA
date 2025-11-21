class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Set<Character> unique = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unique.add(s.charAt(i));
        }
        int res = 0;
        for (char letter : unique) {
            int st = -1;
            int end = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == letter) {
                    if(st==-1){
                        st=i;
                    }
                    end = i;
                }
            }
            Set<Character> set = new HashSet<>();
            for (int x = st + 1; x <= end - 1; x++) {
                set.add(s.charAt(x));
            }
            res += set.size();
        }
        return res;
    }
}