class Solution {
    
    public static void backtrack(ArrayList<ArrayList<Integer>> res,ArrayList<Integer>curr,int nums[],int temp){
        if(temp==nums.length){
            res.add(new ArrayList<>(curr));
            return ;
        }

        curr.add(nums[temp]);
        backtrack(res,curr,nums,temp+1);

        curr.remove(curr.size()-1);
        backt rack(res,curr,nums,temp+1);
    }
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        ArrayList<ArrayList<Integer>>result=new ArrayList<>();
        backtrack(result,new ArrayList<>(),arr,0);
        return result;
    }
}


/*In this particular problem, what we are doing is finding all the possible subsets of the given array. For example, if the array is [2,4], the subsets will be [], [2], [4], and [2,4].

For this, first in the main function, we create a result list which is a list of lists, and then we call our helper recursive function with the result list, a temporary list, the array, and the index initially as 0.

In the helper function, our base case is when the temp index becomes equal to the length of the array. At that point, we have processed all the elements, so we add the current temporary list to the result list and return.

Now, for every element, we have two choices. First, we take the current element, so we add it to our temporary list and recursively call the function with the next index.

After that recursive call is completed, we remove the last element from the temporary list. This is called backtracking, and we do this to undo our previous choice.

Then we make the second recursive call without taking the current element. In this way, for every element, we check both possibilities — take and not take — and finally we get all the possible subsets.

Time Complexity: O(n × 2^n) because there are 2^n possible subsets and copying a subset can take up to O(n) time.

Space Complexity: O(n) for the recursion stack and temporary list, excluding the output.

Output Space: O(n × 2^n) because we store all the subsets.*/
