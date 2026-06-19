class Solution {
    int search(int[] arr, int key) {
         int l=0,h=arr.length-1;
         if(arr.length==1){
            if(arr[0]==key){
                return 0;
            }else{
                return -1;
            }
         }

        while(l<h){
            int mid=l+(h-l)/2;
            if(arr[mid]>arr[h]){
                l=mid+1;
            }else{
                h=mid;
            }
        }
       int piv=l,n=arr.length-1;
       if(arr[piv]<=key && arr[n]>=key){
        l=piv;
        h=arr.length-1;
       }else{
        l=0;
        h=piv-1;
       }

       while(l<=h){
        int mid=l+(h-l)/2;
        if(arr[mid]==key){
            return mid;
        }else if(arr[mid]>key){
            h=mid-1;
        }else{
            l=mid+1;
        }
       }
        return -1;
    }
}

/*In this particular problem, what I have done is that I know the array is sorted but rotated at some point. Since there is a breakpoint where the rotation happens, my first thought is to find that breakpoint (pivot) first.

Once I find the pivot, I know that the subarray from the pivot to the end of the array is sorted. Then I check whether the target lies within that sorted range. If the target belongs to that range,

I simply update my low and high pointers to that side and perform a normal binary search.

If the target does not fall within that range, then it must be present on the other side of the array. So I update my pointers to the left half and again perform a normal binary search there.

The main idea is to first locate the breakpoint and then determine in which sorted half the target can exist. After identifying the correct half, the problem becomes a simple binary search.

We also need to handle some edge cases. For example, if the array size is 1, we only have a single element to check. If that element is equal to the target, we return index `0`; otherwise, we return `-1`.

Another important thing to keep in mind is that we should avoid using `pivot - 1` without proper checks. In some cases, the pivot itself can be at index `0`, which means `pivot - 1` would become `-1`,

leading to invalid indexing. So we need to carefully handle such situations.

**Time Complexity:** `O(log n)` to find the pivot + `O(log n)` for binary search = `O(log n)`

**Space Complexity:** `O(1)`
*/
