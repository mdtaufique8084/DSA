class Solution {
    public int maxTotalFruits(int[][] fruits, int start, int k) {
        int n=fruits.length;
        int maxFruits=Integer.MIN_VALUE;
        int[] prefix=new int[n]; // to store pre sum of O(1) sum cal culcation
        int[] indices=new int[n]; // sorted indices to find low and upper bound
        for(int i=0;i<n;i++){
            indices[i]=fruits[i][0];
            prefix[i]=fruits[i][1] + (i>0 ? prefix[i-1]:0);
        }

        for(int d=0;d<=k/2;d++){ // can not be negative so goes to k/2

            // move left and then right
            int rem=k-2*d;
            int i=start-d;
            int j=start+rem;

            int left=lowerBound(indices,i);
            int right=upperBound(indices,j)-1;

            if(left<=right){
                int total=prefix[right]-(left>0 ? prefix[left-1]:0);
                maxFruits=Math.max(maxFruits,total);
            }

            // move right and then left
            rem=k-2*d;
            i=start-rem;
            j=start+d;

            left=lowerBound(indices,i);
            right=upperBound(indices,j)-1;

            if(left<=right){
                int total=prefix[right]-(left>0 ? prefix[left-1]:0);
                maxFruits=Math.max(maxFruits,total);
            }
        }
        return maxFruits==Integer.MIN_VALUE ? 0:maxFruits;
    }

    private int lowerBound(int[] arr,int target){
        int low=0;
        int high=arr.length;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
    private int upperBound(int[] arr,int target){
        int low=0;
        int high=arr.length;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=target){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
}