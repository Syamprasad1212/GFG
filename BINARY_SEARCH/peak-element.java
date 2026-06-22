class Solution {
    public int peakElement(int[] arr) {
        int n=arr.length;
        int l=0,h=n-1;

        while(l<h){
            int mid=l+(h-l)/2;
           if(arr[mid]<arr[mid+1]){
                l=mid+1;
            }else{
                h=mid;
            }
        }
        return l;
    }
}

/*For this problem, I use a Binary Search approach instead of checking every element. The key observation is that we do not need to find all peak elements; we only need to find any one peak element.

The idea is based on the slope around the middle element. At every step, I compare the middle element with its next element.

If:

arr[mid] < arr[mid + 1]

then I am currently on an increasing slope. This means a peak element must exist on the right side. The reason is that either the array continues increasing until the end, making the last element a peak, or it starts decreasing at some point, creating a peak before that decrease. Therefore, I move to the right half by updating:

low = mid + 1

If:

arr[mid] > arr[mid + 1]

then I am on a decreasing slope. In this case, a peak element must exist on the left side, possibly at the current middle element itself. Therefore, I move to the left half by updating:

high = mid

By repeatedly eliminating half of the search space, the pointers eventually meet at a single index. When "low == high", that position is guaranteed to be a peak element, and I return its index.

One important advantage of this approach is that it automatically handles all edge cases. Whether the peak element is at the first position, last position, or somewhere in the middle, the Binary Search naturally converges to it without requiring any separate checks.

Example

[1,2,3,4]

The array keeps increasing, so the last element becomes the peak.

Output:

index = 3

---

[4,3,2,1]

The array keeps decreasing, so the first element becomes the peak.

Output:

index = 0

Time Complexity

O(log n)

Because the search space is reduced by half in every iteration.

Space Complexity

O(1)

Because only a few variables are used and no extra space is required.

Important Observation

arr[mid] < arr[mid + 1]
→ Peak exists on the right side.

arr[mid] > arr[mid + 1]
→ Peak exists on the left side (including mid).

This observation is the monotonic property that makes Binary Search possible in this problem.*/
