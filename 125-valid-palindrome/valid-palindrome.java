class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty() || s==null) return true; // empty & null string are always pallindrome
        int n=s.length();
        int i=0,j=n-1;
        s=s.toLowerCase();
        while(i<j){
            // condition to remove all the non alphanumeric character from left
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            // condition to remove all the non alphanumeric character from right
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}