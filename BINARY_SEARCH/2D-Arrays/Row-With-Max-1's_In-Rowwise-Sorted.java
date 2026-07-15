class Solution {
    public int rowWithMax1s(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int maxcount=0,idx=-1;
        
        for(int i=0;i<n;i++){
            int l=0,h=m-1;
            while(l<=h){
                int mid=l+(h-l)/2;
                if(arr[i][mid]==1){
                    h=mid-1;
                }else {
                    l=mid+1;
                }
            }
            int count=m-l;
            if(count>maxcount){
                maxcount=count;
                idx=i;
            }else if(count==maxcount){
                if(idx>i){
                    idx=i;
                }
            }
        }
        return idx;
    }
};


/*Approach

For this problem, an important observation is that each individual row is sorted. Every row contains either:

All 0s,
All 1s, or
0s followed by 1s.

Because of this property, we can apply binary search on each row. However, we cannot perform binary search on the entire matrix because the 

matrix is not globally sorted. Only each row is sorted independently.

For every row, I perform a binary search over its columns to find the first occurrence of 1.

If the current element is 1, I move to the left half to check whether there is another 1 appearing earlier.
If the current element is 0, I move to the right half because the first 1 can only appear there.

After the binary search ends, the low pointer points to the index of the first 1 in that row. Therefore, the number of 1s in the row is simply:

count = number of columns - low

I then compare this count with the maximum count found so far.

If the current count is greater than the maximum count, I update both the maximum count and the row index.
If two rows have the same number of 1s, I keep the row with the smaller index, as required by the problem.

Finally, I return the index of the row containing the maximum number of 1s`.

Time Complexity
O(n log m)
We perform binary search (O(log m)) for each of the n rows.
Space Complexity
O(1)
Only a few extra variables are used.*/
