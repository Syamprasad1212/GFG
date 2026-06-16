class Solution {
    public int findFloor(int[] arr, int x) {
         int n=arr.length;
        int ans=-1;
        int l=0,h=n-1;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]<=x){
                ans=mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
}
/*Floor in a Sorted Array is the largest element that is less than or equal to the target (`<= target`).

The idea is very similar to the Lower Bound approach, but the direction of the search changes. Whenever we find an element that is less than or equal to the target, 
that element can be a possible floor answer. We store it and try to find a larger valid element by moving to the right side of the array.

If `arr[mid] <= target`, going to the left side is not useful because all elements on the left are smaller or equal to the current element. The current element 
may already be the answer, but there could be a better floor on the right side that is still less than or equal to the target. Therefore, we store the current answer and move right using `low = mid + 1`.

If `arr[mid] > target`, the current element cannot be the floor because it is larger than the target. In this case, we move left using `high = mid - 1`.

We initialize `ans = -1` because if no element in the array is less than or equal to the target, then a floor does not exist.

After the binary search ends, `ans` contains the largest element that is less than or equal to the target, which is the required floor value.*/