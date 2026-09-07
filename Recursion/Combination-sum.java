class Solution {
    public static void combinations(int idx,int []arr,int t,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> res){
        int n=arr.length;
        if(n==idx){
            if(t==0){
                ans.add(new ArrayList<>(res));
            }
                return;
        }
        
        if(arr[idx]<=t){
            res.add(arr[idx]);
            combinations(idx,arr,t-arr[idx],ans,res);
            res.remove(res.size()-1);
        }
        combinations(idx+1,arr,t,ans,res);
        
    }
    
    public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        
        combinations(0,arr,target,ans,new ArrayList<>());
        return ans;
    }
}


/*In this problem, first we create an ArrayList of ArrayList to store all the required combinations. Then, from the main function, we call our recursive helper function.

In the recursive function, at every index, we have two choices: either take the current element or not take it.

If we take the element, we subtract its value from the target and call the recursive function again with the same index, because the same element can be used again.
If we do not take the element, we move to the next index and continue the process.

Our base case is when the index becomes equal to the length of the array. At that point, we check whether our target has become 0. If the target is 0, it means we have found a valid combination, so we add a copy of our current combination to the resultant list.

After adding the combination, we return back to the previous recursive call and continue exploring the other possible choices. In this way, we keep taking or skipping elements and backtrack whenever required until we find all the possible combinations.

Time Complexity: O(2^n) approximately for the recursion tree, but because an element can be reused multiple times and we generate/store combinations, the exact complexity depends on the target and array values.

Space Complexity: O(n) for the recursion stack and the current combination, excluding the space required to store the final answer.*/
