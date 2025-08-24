class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int n=nums.size();
        int lastseen=-1;
        int i=0,j=0,res=0;
        while(j<n){
            if(nums[j]==0){
                i=lastseen+1;
                lastseen=j;
            }
            res=max(res,j-i);
            j++;
        }
        return res;
    }
};