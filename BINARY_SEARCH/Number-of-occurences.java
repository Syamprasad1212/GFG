class Solution {
    int lowerbound(int []arr,int target){
        int l=0,h=arr.length-1;
        int ans=h+1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]>=target){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    
     int upperbound(int []arr,int target){
        int l=0,h=arr.length-1;
        int ans=h+1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]>target){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    
    int countFreq(int[] arr, int target) {
        int len=arr.length;
        int lb=lowerbound(arr,target);
        int up=upperbound(arr,target);
        int res=up-lb;
        return res;
    }
}
/*For this problem, we need to count the number of occurrences of a target element in a sorted array. A brute-force approach would be to traverse the entire array and count the occurrences, but since the array is sorted, we can optimize it using binary search.

The key observation is that if we can find the first occurrence and the position just after the last occurrence of the target, then the difference between these two positions will give us the total count.

To achieve this, we use two binary search functions:

* **Lower Bound**: Finds the first index where the element is greater than or equal to the target. If the target exists in the array, this will point to its first occurrence.
* **Upper Bound**: Finds the first index where the element is strictly greater than the target. This effectively points to the position just after the last occurrence of the target.

Once we obtain these two indices, the count of the target is:

`count = upperBound - lowerBound`

There are a few edge cases to consider. If the target is not present in the array, both lower bound and upper bound will point to the same position (the index where the target would be inserted), resulting in a count of `0`. 
This case is automatically handled by the binary search functions.

Another important case occurs when the target appears at the end of the array. In such situations, there is no element greater than the target. To handle this, we initialize the answer for both lower bound and upper bound 
as `n` (the size of the array). Therefore, if no greater element exists, the upper bound naturally becomes `n`, and the formula `upperBound - lowerBound` still produces the correct count.

**Time Complexity:** O(log n) + O(log n) = O(log n)

**Space Complexity:** O(1)
*/
