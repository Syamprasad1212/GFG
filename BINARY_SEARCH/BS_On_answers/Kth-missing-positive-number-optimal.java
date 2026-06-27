class Solution {
    public int findKthPositive(int[] arr, int k) {
       int l=0,h=arr.length-1;

       while(l<=h){
        int mid=l+(h-l)/2;
        int miss=arr[mid]-(mid+1);
        if(miss<k){
            l=mid+1;
        }else{
            h=mid-1;
        }
       }
       return h+1+k;
    }
}


/*Optimal Approach (Binary Search)

Intuition

A normal binary search or binary search on the answer cannot be applied directly because the kth missing number is not present in the array.

Instead, we observe that at any index "mid", we can calculate how many positive numbers are missing before that position using:

"missing = arr[mid] - (mid + 1)"

This value is monotonic (it never decreases), making it suitable for binary search. Once we know how many numbers are missing at "mid", we can determine whether the kth missing number lies to the left or right.

Approach

- Initialize "low = 0" and "high = n - 1".
- For every "mid", compute:
  missing = arr[mid] - (mid + 1)
- If "missing < k", the kth missing number lies on the right, so set "low = mid + 1".
- Otherwise, it lies on the left, so set "high = mid - 1".
- Continue until the search space is exhausted.

At the end of the binary search, "low" represents the number of array elements that are smaller than the kth missing positive number. Therefore, the answer is:

low + k

This works because "low" existing numbers appear before the answer, so we need to shift the kth missing number by "low".

Time Complexity

O(log n)

Space Complexity

O(1)*/
