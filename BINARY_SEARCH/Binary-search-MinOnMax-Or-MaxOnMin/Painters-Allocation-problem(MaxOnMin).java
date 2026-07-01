//Maximum calculate and take minimum 
class Solution {
    public boolean canPaint(int []arr, int mid, int k){
        int painted=0,count=1;
        
        for(int i=0;i<arr.length;i++){
            if(painted+arr[i]<=mid){
                painted+=arr[i];
            }else{
                count++;
                painted=arr[i];
            }
        }
        return count<=k;
        
    }
    public int minTime(int[] arr, int k) {
        int n=arr.length;
        if(n<k) return -1;
        int l=0,h=0;
        
        for(int num:arr){
            l=Math.max(l,num);
            h+=num;
        }
        
        while(l<=h){
            int mid=l+(h-l)/2;
            if(canPaint(arr,mid,k)){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}

/*
This problem is very similar to Allocate Books and Split Array Largest Sum. It is a Binary Search on Answer problem of the Minimize the Maximum type.

The goal is to assign all the boards to k painters such that each painter paints only contiguous boards, and the maximum painting time among all painters is minimized.

The first step is to determine the Binary Search range.

The minimum possible answer is the maximum board length because one painter must paint the largest board, and a board cannot be split.
The maximum possible answer is the sum of all board lengths because one painter can paint every board.

So, our search range is:

low = maximum board length
high = sum of all board lengths

For every middle value (mid), I consider it as the maximum amount of work one painter is allowed to do. Then, using a helper function, I calculate how many painters are required if no painter is allowed to paint more than mid units.

Inside the helper function, I keep adding board lengths to the current painter. Whenever adding the next board exceeds mid, I assign that board to a new painter and continue the process. By the end of the traversal, I know exactly how many painters are needed for the current value of mid.

If the required number of painters is less than or equal to k, then the current mid is a valid answer. Since the problem asks for the minimum possible maximum painting time, I search on the left side by updating high = mid - 1.
If the required number of painters is greater than k, then the current value of mid is too small, so I search on the right side by updating low = mid + 1.

I continue this process until the Binary Search ends. Since this is a Minimize the Maximum problem, the answer is low after the loop terminates because low points to the smallest valid maximum painting time.

Time Complexity
O(n × log(sumOfBoards))
Binary Search performs O(log(sumOfBoards)) iterations.
In each iteration, the helper function traverses the array once, taking O(n) time.
Space Complexity
O(1)

Only a few extra variables are used.
*/
