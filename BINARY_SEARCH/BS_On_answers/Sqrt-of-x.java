class Solution {
    int floorSqrt(int n) {
        int l=0,h=n,ans=0;
        if(n==1) return 1;
        if(n==0) return 0;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            
            if(mid==n/mid){
                return mid;
            }else if(mid<=n/mid){
                ans=mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        
        return ans;
    }
}

/*In this problem, we need to find the floor value of the square root of a number n. The floor square root is the largest integer whose square is less than or equal to n.

A brute force solution would check every possible value, but since the answer lies within a sorted range from 0 to n, we can use Binary Search to optimize the solution.

The key observation is that for any number mid:

mid² <= n

means mid can be a possible answer. However, directly calculating mid * mid may cause integer overflow for large values of n. To avoid this, we rewrite the condition as:

mid <= n / mid

which is mathematically equivalent and completely safe from overflow.

During Binary Search:

If mid == n / mid, we have found the exact square root, so we return mid.
If mid <= n / mid, then mid is a valid answer because mid² <= n. We store it in ans and move to the right side to check whether a larger valid answer exists.
If mid > n / mid, then mid² > n, so mid cannot be part of the answer. We move to the left side.

We continue this process until the search space becomes empty. If an exact square root is not found, the variable ans will contain the largest integer whose square is less than or equal to n, which is the required floor square root.

Example
n = 27

Check:

5² = 25 <= 27
6² = 36 > 27

Since 5 is the largest valid integer whose square does not exceed 27, the answer is:

floor(√27) = 5
Key Observation
mid² <= n

can be safely written as:

mid <= n / mid

to avoid integer overflow.

Time Complexity
O(log n)

because Binary Search halves the search space in every iteration.

Space Complexity
O(1)

because only a few variables are used.*/
