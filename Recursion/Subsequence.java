import java.util.Arrays;

class Solution {

    public static boolean subs(int index, int arr[], int sum, int k, int[][] memo) {

        if (sum > k) {
            return false;
        }

        if (index == arr.length) {
            return sum == k;
        }

        // Already calculated this state
        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }

        // Take
        boolean taken = subs(index + 1, arr, sum + arr[index], k, memo);

        if (taken) {
            memo[index][sum] = 1;
            return true;
        }

        // Don't take
        boolean notTaken = subs(index + 1, arr, sum, k, memo);

        if (notTaken) {
            memo[index][sum] = 1;
            return true;
        }

        memo[index][sum] = 0;
        return false;
    }

    public boolean checkSubsequenceSum(int[] arr, int k) {

        int[][] memo = new int[arr.length][k + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return subs(0, arr, 0, k, memo);
    }
}


/*In this problem, what we are doing is using recursion with memoization.

Initially, we start from index = 0 and sum = 0. For every element, we have two choices:

We can take the current element, so we add arr[index] to sum.
We can not take the current element, so we keep the same sum.

Then in both cases, we move to the next index.

take     → sum + arr[index]
not take → sum

We continue doing this until we reach the end of the array.

When:

index == arr.length

there are no more elements to consider. So we simply check:

sum == k → true
sum != k → false

Also, because all the array elements are positive, if sum > k, we can directly return false, because the sum can never come back down to k.

Now the problem with normal recursion is that the same (index, sum) state can be reached multiple times. If we calculate that state again and again, we get TLE.

So we create a memo array where:

memo[index][sum]

stores the answer for that particular state.

Initially we keep it as -1, meaning:

-1 → not calculated yet
0  → false
1  → true

So whenever we reach a state, first we check whether its answer is already stored. If it is stored, we directly return that answer instead of doing the recursive calls again.

Finally, if the take branch gives true, we immediately return true. Otherwise, we check the not-take branch. If both branches fail, we return false.*/
