class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n=nums.size();
        int maxRechable=0;
        for(int i=0;i<n;i++){
            if(i>maxRechable) return false;
            maxRechable=max(maxRechable,i+nums[i]);
        }
        return true;
    }
};