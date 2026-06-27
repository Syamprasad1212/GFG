class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;

        for(int num:arr){
            if(num<=k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }
}



/*Brute Force
Intuition

We iterate through the array and keep adjusting k whenever we encounter a number that is less than or equal to the current value of k.

Approach
Traverse the array from left to right.
For each element:
If the current element is less than or equal to k, it means this number exists in the array and is not missing. So, increment k to look for the next missing number.
If the current element is greater than k, we have found a gap, so the kth missing positive number must lie before this element. We can stop the traversal.
Finally, return k.
Time Complexity

O(n)

Space Complexity

O(1)*/
