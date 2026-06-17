class Solution {
    public int findMin(int[] arr) {
        int l=0,h=arr.length-1;

        while(l<h){
            int mid=l+(h-l)/2;
            if(arr[mid]>arr[h]){
                l=mid+1;
            }else{
                h=mid;
            }
        }
        return arr[l];
    }
}
/*Since this array is sorted but rotated, using a simple traversal to find the minimum element would take **O(n)** time. 
To optimize it, we can use **Binary Search** because the array still retains some sorted properties even after rotation. 
The main observation is that there is exactly one position where the sorted order breaks, and the minimum element lies at that break point. 
During each iteration, we calculate the middle index and compare `nums[mid]` with `nums[high]`. If `nums[mid]` is greater than `nums[high]`,
it means the break point and the minimum element must be on the right side of `mid`, so we move our `low` pointer to `mid + 1`. Otherwise, 
if `nums[mid]` is less than `nums[high]`, it means the right portion is already sorted and the minimum element could either be at `mid` itself 
or somewhere to its left. In this case, we move `high` to `mid` instead of `mid - 1` because removing `mid` could cause us to miss the minimum 
element when `mid` itself is the answer. By repeatedly eliminating half of the search space in this manner, we eventually reach a point where 
`low` and `high` become equal, and that index contains the minimum element. This approach reduces the time complexity from **O(n)** to **O(log n)** while using only **O(1)** extra space.*/
