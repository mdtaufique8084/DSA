class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i]==0){
                continue;
            }
            boolean isPos = nums[i] > 0;
            int curr = i;
            int slow=i;
            int fast=i;
            do{
                slow=calculateNext(nums,slow);
                fast=calculateNext(nums,fast);
                if(isPos){
                    if(nums[fast]<0){
                        break;
                    }
                }
                else{
                    if(nums[fast]>0){
                        break;
                    }
                }
                fast=calculateNext(nums,fast);
                if(isPos){
                    if(nums[fast]<0){
                        break;
                    }
                }
                else{
                    if(nums[fast]>0){
                        break;
                    }
                }

                if(slow==fast){
                    if(slow!=calculateNext(nums,slow)){
                        return true;
                    }
                    break;
                }
            }
            while(slow!=fast);
            curr=i;
            if(isPos){
                while(nums[curr]>0){
                    int next=calculateNext(nums,curr);
                    nums[curr]=0;
                    curr=next;
                }
            }
            else{
                while(nums[curr]<0){
                    int next=calculateNext(nums,curr);
                    nums[curr]=0;
                    curr=next;
                }
            }

        }
        return false;
    }

    private int calculateNext(int[] nums, int curr) {
        int n = nums.length;
        int next = curr + nums[curr];
        next = next % n;
        if (next < 0) {
            next += n;
        }
        return next;
    }
}