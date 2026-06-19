class Solution {
    public boolean search(int[] nums, int target) {
         int l=0,h=nums.length-1;
       while(l<=h){
        int mid=l+(h-l)/2;
        if(nums[mid]==target){
            return true;
        }

        if(nums[l]==nums[mid] && nums[mid]==nums[h]){
            l++;
            h--;
            continue;
        }
        
        if(nums[l]<=nums[mid]){
        if(nums[l]<=target && target<=nums[mid]){
            h=mid-1;
        }else{
            l=mid+1;
        }
        }else{
            if(nums[mid]<=target && nums[h]>=target){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        
       }
        return false;
    }
}

/*In this problem, I decided not to find the pivot explicitly. Instead, I directly applied Binary Search while handling the duplicate elements carefully.

The first thing I check is whether the middle element is equal to the target. If it is, I immediately return `true`.

The tricky part of this problem is when the starting element, middle element, and ending element are all the same. In this situation, I cannot determine which side is sorted because the duplicates 

hide the information needed to make that decision. To handle this case, I simply shrink the search space by incrementing the left pointer and decrementing the right pointer.

After handling duplicates, I check which half is sorted. If the left half is sorted, I verify whether the target lies within the range from `low` to `mid`. If it does, I move to the left half by updating the right pointer. Otherwise, I move to the right half.

Similarly, if the right half is sorted, I check whether the target lies within the range from `mid` to `high`. If it does, I move to the right half by updating the left pointer. Otherwise, I move to the left half.

In every iteration, I eliminate one half of the search space based on where the target can possibly exist. I continue this process until I either find the target or the search space becomes empty.

If the target is found at any point, I return `true`. If the loop ends without finding the target, I return `false`.

**Time Complexity:**

* Average Case: `O(log n)`
* Worst Case: `O(n)` (when many duplicate elements force us to shrink the search space one element at a time)

**Space Complexity:**

* `O(1)`
*/
