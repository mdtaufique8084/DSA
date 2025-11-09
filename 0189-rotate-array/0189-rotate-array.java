class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        rotateArray(nums,0,n-k-1);
        rotateArray(nums,n-k,n-1);
        rotateArray(nums,0,n-1);
    }
    private void rotateArray(int[] arr,int i,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}