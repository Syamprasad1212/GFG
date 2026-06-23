class Solution {
    int floorSqrt(int n) {
        int ans=0;
       for(int i=1;i*i<=n;i++){
           ans=i;
       }
       return ans;
    }
}

/*For the brute force approach, the idea is to find the floor value of the square root of a number n.

I start from 1 and keep checking whether the square of the current number is less than or equal to n. As long as i * i <= n, the current value of i can be a possible answer because its square does not exceed n.

Whenever the condition is satisfied, I store the current value as my answer and continue checking larger numbers. The moment i * i becomes greater than n, I stop because any larger value will also have a square greater than n.

At the end, the last valid value stored in the answer variable will be the largest integer whose square is less than or equal to n, which is exactly the floor value of the square root.

Example
n = 10

Check:

1² = 1   <= 10
2² = 4   <= 10
3² = 9   <= 10
4² = 16  > 10

The last valid value is:

3

Therefore:

floor(√10) = 3
Key Observation

The floor square root of a number n is:

Largest integer x such that x² ≤ n

This observation is the foundation for both the brute force and Binary Search solutions.

Time Complexity
O(√n)

because we only iterate until i² exceeds n.

Space Complexity
O(1)

because only a few variables are used.*/
