class Solution {
public:
    int dp[101];
    int solve(int idx,string &s,int &n){
        if(dp[idx]!=-1){
            return dp[idx];
        }
        if(idx==n){
            return dp[idx]= 1;
        }
        if(s[idx]=='0'){
            return dp[idx]= 0;
        }
        int result=solve(idx+1,s,n);  // single character
        if(idx+1<n){
            if(s[idx]=='1' || (s[idx]=='2' && s[idx+1]<'7')){
                result+=solve(idx+2,s,n); // more then one character
            }
        }
        return dp[idx]= result;
    }
    int numDecodings(string s) {
        int n=s.length();
        memset(dp,-1,sizeof(dp));
        return solve(0,s,n);
    }
};