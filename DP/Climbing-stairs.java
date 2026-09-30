import java.util.*;
class Solution {
    public static int dp(int n,int []dpp){
           if(n==1)return 1;
           if(n==2) return 2;

           if(dpp[n]!=-1) return dpp[n];
           return dpp[n]=dp(n-1,dpp)+dp(n-2,dpp);
       }
    public int countWays(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return dp(n,dp);
    }
}
