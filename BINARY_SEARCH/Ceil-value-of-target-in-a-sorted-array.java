class Solution {
    public int findCeil(int[] arr, int x) {
             int n=arr.length;
        int ans=-1;
        int l=0,h=n-1;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]>=x){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}
/*Ceiling in a Sorted Array is the smallest element that is greater than or equal to the target (`>= target`).

The idea is very similar to the Lower Bound approach. Whenever we find an element that is greater than or equal to the target, that element can be a possible ceiling answer.
 We store it and try to find a smaller valid element by moving to the left side of the array.

If `arr[mid] >= target`, going to the right side is not useful because all elements on the right are greater than or equal to the current element. The current element may 
already be the answer, but there could be a better ceiling on the left side that is still greater than or equal to the target. Therefore, we store the current answer and move left using `high = mid - 1`.

If `arr[mid] < target`, the current element cannot be the ceiling because it is smaller than the target. In this case, we move right using `low = mid + 1`.

We initialize `ans = -1` because if no element in the array is greater than or equal to the target, then a ceiling does not exist.

After the binary search ends, `ans` contains the smallest element that is greater than or equal to the target, which is the required ceiling value.
*/