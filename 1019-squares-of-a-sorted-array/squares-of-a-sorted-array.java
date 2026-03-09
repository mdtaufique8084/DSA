class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = -1, right = -1;

        // finding the pivit index which is smallest negative
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                break;
            }
            left = left + 1;
        }
        right = left + 1;
        int idx = 0;

        // merging two sorted array 
        // array 1= sorted negative part 
        // array 2=sorted positive part
        while (left >= 0 && right < n) {
            int sq1 = nums[left] * nums[left];
            int sq2 = nums[right] * nums[right];
            if (sq1 <= sq2) {
                res[idx++] = sq1;
                left--;
            } else {
                res[idx++] = sq2;
                right++;
            }
        }

        // merging

        while(left>=0){
            res[idx++]=nums[left]*nums[left];
            left--;
        }

        while(right<n){
            res[idx++]=nums[right]*nums[right];
            right++;
        }

        return res;
    }
}