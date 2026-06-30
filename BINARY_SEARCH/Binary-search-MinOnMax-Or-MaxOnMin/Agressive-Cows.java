class Solution {
    public boolean canPlace(int []arr,int mid,int k){
        int count=1,lastPlaced=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=lastPlaced+mid){
                lastPlaced=arr[i];
                count++;
                if(count==k) return true;
            }
        }
        return false;
    }
    public int aggressiveCows(int[] stalls, int k) {
        int n=stalls.length;
        Arrays.sort(stalls);
        int l=1;
        int h=(stalls[n-1]-stalls[0]);
        
        while(l<=h){
            int mid=l+(h-l)/2;
            if(canPlace(stalls,mid,k)){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        
        return h;
    }
}

/*
This problem is a little different from the usual Binary Search on Answer problems. Here, we are not directly finding a minimum or maximum value. Instead, we are solving a Maximize the Minimum type of problem.

The idea is that for every possible minimum distance between two cows, we check whether it is possible to place all k cows while maintaining at least that minimum distance. Among all the valid minimum distances, we want the maximum one.

First, I sort the stalls array because the cows must be placed in increasing order of positions.

Then, I define my Binary Search range:

low = 1 (minimum possible distance)
high = last stall - first stall (maximum possible distance)

For every middle value (mid), I consider it as the minimum distance that must be maintained between any two cows.

To verify whether this distance is possible, I use a separate helper function. Inside the helper function:

I place the first cow at the first stall.
I keep track of the position of the last placed cow.
I traverse the array from the second stall onward.
Whenever the distance between the current stall and the last placed cow is greater than or equal to mid, I place another cow there, increment the cow count, and update the last placed position.
After traversing the entire array, I check whether I was able to place at least k cows.
If the helper function returns true, it means the current minimum distance is possible. Since we want to maximize this minimum distance, I search on the right side by updating low = mid + 1.
If it returns false, the distance is too large, so I search on the left side by updating high = mid - 1.

I continue this process until the Binary Search ends. At the end, high represents the largest minimum distance possible, which is the required answer.

Time Complexity
O(n log n + n × log(maxDistance))
O(n log n) for sorting the stalls.
Binary Search runs for O(log(maxDistance)) iterations.
In each iteration, the helper function traverses the array once, taking O(n) time.
Space Complexity
O(1)

Only a few extra variables are used (excluding the space used by the sorting algorithm implementation).
*/
