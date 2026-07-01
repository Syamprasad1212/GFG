class Solution {
    public boolean canAllocate(int arr[],int mid,int k){
        int pages=0,Sc=1;
        for(int i=0;i<arr.length;i++){
            if(pages+arr[i]<=mid){
                pages+=arr[i];
            }else{
                Sc++;
                pages=arr[i];
                
                if(Sc>k) return false;
            }
        }
        return true; 
    }
    public int splitArray(int[] arr, int k) {
       int n=arr.length,l=0,h=0;
       
       if(n<k) return -1;
       
       for(int num:arr){
           l=Math.max(l,num);
           h+=num;
       }
       
       while(l<=h){
           int mid=l+(h-l)/2;
           if(canAllocate(arr,mid,k)){
               h=mid-1;
           }else{
               l=mid+1;
           }
       }
       return l;
    }
} 
/*
This problem is a Binary Search on Answer problem of the Minimize the Maximum type.

We need to split the array into exactly k contiguous subarrays such that the largest subarray sum is minimized.

The first step is to determine the Binary Search range.

The minimum possible answer is the maximum element in the array because every subarray must contain at least one element. Therefore, the largest subarray sum can never be smaller than the largest element.
The maximum possible answer is the sum of all the elements because the entire array can be considered as a single subarray.

So, our search range is:

low = maximum element in the array
high = sum of all elements

For every middle value (mid), I consider it as the maximum allowed sum of a subarray. Then, using a helper function, I check how many subarrays are required if no subarray is allowed to have a sum greater than mid.

Inside the helper function, I keep adding elements to the current subarray. Whenever adding the next element exceeds mid, I start a new subarray and continue the process. By the end of the traversal, I know exactly how many subarrays are required for the current value of mid.

If the required number of subarrays is less than or equal to k, then the current mid is a valid answer. Since the problem asks for the minimum possible largest subarray sum, I search on the left side by updating high = mid - 1.
If the required number of subarrays is greater than k, then the current value of mid is too small, so I search on the right side by updating low = mid + 1.

I continue this process until the Binary Search ends. Since this is a Minimize the Maximum problem, the answer is low after the loop terminates because low points to the smallest valid maximum subarray sum.

Important Points
Set low to the maximum element in the array.
Set high to the total sum of the array.
The helper function calculates the number of subarrays required for the current maximum allowed sum.
If the current limit requires k or fewer subarrays, try a smaller limit.
Otherwise, increase the limit.
Since this is a Minimize the Maximum problem, return low after Binary Search ends.
Time Complexity
O(n × log(sum(nums)))
Binary Search performs O(log(sum(nums))) iterations.
In each iteration, the helper function traverses the array once, taking O(n) time.
Space Complexity
O(1)

Only a few extra variables are used.
*/
