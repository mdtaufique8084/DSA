class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(0,nums.length-1,nums);
    }
    private int mergeSort(int i,int j,int[] nums){
        int count=0;
        if(i>=j){
            return count;
        }
        int mid=(i+j)/2;
        count+=mergeSort(i,mid,nums);
        count+=mergeSort(mid+1,j,nums);
        count+=countPairs(i,mid,j,nums);
        merge(i,mid,j,nums);
        return count;
    }
    private void merge(int beg,int mid,int end,int[] nums){
        int left=beg;
        int right=mid+1;
        int k=beg;
        int[] temp=new int[nums.length];
        while(left<=mid && right<=end){
            if(nums[left]<=nums[right]){
                temp[k]=nums[left];
                left++;
            }
            else{
                temp[k]=nums[right];
                right++;
            }
            k++;
        }

        while(left<=mid){
            temp[k]=nums[left];
            left++;
            k++;
        }

        while(right<=end){
            temp[k]=nums[right];
            right++;
            k++;
        }

        for(int x=beg;x<=end;x++){
            nums[x]=temp[x];
        }
    }

    private int countPairs(int beg,int mid,int end,int[] nums){
        int count=0;
        int right=mid+1;
        for(int i=beg;i<=mid;i++){
            while(right<=end && (long)nums[i]>2L*nums[right]){
                right++;
            }
            count+=(right-(mid+1));
        }
        return count;
    }
}
