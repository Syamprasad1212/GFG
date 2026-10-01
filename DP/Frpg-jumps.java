import java.util.*;
class Solution {
    public static int frogs(int idx,int []dp,int []h){
        if(idx==0){
            return 0;
        }

        if(dp[idx]!=-1) return dp[idx];

        int left =frogs(idx-1,dp,h)+Math.abs(h[idx]-h[idx-1]);
        int right=Integer.MAX_VALUE;
        if(idx>1){
         right=frogs(idx-2,dp,h)+Math.abs(h[idx]-h[idx-2]);
        }
        return dp[idx]=Math.min(left,right);   
         }
    public int frogJump(int[] heights) {
        int n=heights.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return frogs(n-1,dp,heights);
    }
}



/*First, we build the recursive solution for the problem. The idea is to find the minimum energy required to reach the current index by considering both possible jumps:

Jump from idx - 1
Jump from idx - 2

For each jump, we calculate the energy using:

abs(height[idx] - height[previousIndex])

Then we take the minimum of the two possibilities.

However, in the recursive solution, the same function calls and values can be calculated again and again. This creates unnecessary work.

To optimize this, we use Dynamic Programming (DP) with memoization.

We create a 1D DP array where dp[idx] stores the minimum energy required to reach index idx.

Before making a recursive call, we check whether dp[idx] already contains the answer:

If it is already calculated, we directly return dp[idx].
If it is not calculated, we recursively calculate the answer, store it in dp[idx], and then return it.

For every index, we calculate the cost of both possible jumps, compare them using Math.min(), and store the minimum value in the DP array.

This way, each index is calculated only once, which significantly reduces the number of recursive calls.

Time Complexity

O(N)

Each index is calculated only once, and each calculation performs constant work for the two possible jumps.

Space Complexity

O(N)

O(N) for the DP array.
O(N) for the recursion call stack in the worst case.

Therefore, the total auxiliary space is O(N).*/
