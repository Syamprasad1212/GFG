/*we require Min value from Maximum values*/
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
    public int findPages(int[] arr, int k) {
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
This problem is very similar to Aggressive Cows, but the Binary Search direction is the opposite. Aggressive Cows is a Maximize the Minimum problem, whereas Allocate Books is a Minimize the Maximum problem. Understanding this polarity is the key to solving the problem.

The first step is to determine the Binary Search range.

The minimum possible answer is the maximum number of pages in the array because a student must be assigned an entire book, so the answer can never be smaller than the largest book.
The maximum possible answer is the sum of all the pages because one student could be assigned every book.

So, our search range is:

low = maximum element in the array
high = sum of all elements

For every middle value (mid), I consider it as the maximum number of pages that one student is allowed to read. Then, using a helper function, I check how many students are required if no student is allowed to read more than mid pages.

Inside the helper function, I keep adding pages to the current student. Whenever adding the next book exceeds mid, I allocate that book to a new student and continue the process. By the end of the traversal, I know exactly how many students are needed for the current value of mid.

If the required number of students is less than or equal to the given number of students, then the current mid is a valid answer. Since the problem asks for the minimum possible maximum pages, I search on the left side by updating high = mid - 1.
If the required number of students is greater than the given number of students, then the current value of mid is too small. We need to allow more pages per student, so I search on the right side by updating low = mid + 1.

I continue this process until the Binary Search ends. Since this is a Minimize the Maximum problem, the answer is low after the loop terminates. This happens because of the Binary Search polarity: we keep eliminating invalid smaller answers until low reaches the smallest valid answer.

Important Points
Set low to the maximum element because one student must be able to hold the largest book.
Set high to the total sum of pages because one student can read all the books.
The helper function calculates the number of students required for the current maximum page limit.
If the current limit can be achieved using the given number of students or fewer, try a smaller limit.
Otherwise, increase the limit.
Since this is a Minimize the Maximum problem, return low at the end.
Time Complexity
O(n × log(sumOfPages))
Binary Search performs O(log(sumOfPages)) iterations.
In each iteration, the helper function traverses the array once, taking O(n) time.
Space Complexity
O(1)

Only a few extra variables are used.
*/
