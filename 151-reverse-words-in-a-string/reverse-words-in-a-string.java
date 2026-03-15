class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        reverse(arr, 0, n - 1);
        int i = 0, l = 0, r = 0;
        while (i < n) {
            while (i < n && arr[i] != ' ') {
                arr[r++] = arr[i++];
            }
            if (l < r) {
                reverse(arr, l, r - 1);
                if (r < n) {     // prevent out of bound
                    arr[r++] = ' ';
                }
                l = r;
            }
            i++;
        }
        return new String(arr, 0, r).trim();
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}