class Solution {
    public int numOfSubarrays(int[] arr, int k, int th) {
        int count=0;
        int n=arr.length;
        int left=0,right=0;
        int currSum=0;
        while(right<n){
            currSum+=arr[right];
            int window=right-left+1;
            if(window==k){
                int avg=currSum/window;
                if(avg>=th){
                    count++;
                }
                currSum-=arr[left];
                left++;
            }
            right++;
        }
        return count;
    }
}