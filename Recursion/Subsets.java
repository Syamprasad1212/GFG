class Solution {

    public static void backtrack(List<List<Integer>> res,List<Integer>curr,int nums[],int temp){
        if(temp==nums.length){
            res.add(new ArrayList<>(curr));
            return ;
        }

        curr.add(nums[temp]);
        backtrack(res,curr,nums,temp+1);

        curr.remove(curr.size()-1);
        backtrack(res,curr,nums,temp+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        backtrack(result,new ArrayList<>(),nums,0);
        return result;
    }
}


/*In this problem, first of all, we call the recursive function. Initially, we add the current element to the curr list and make another recursive call with the next index. 

We keep doing this until temp == nums.length, which means we have considered all the elements. At that point, we add the current list to the resultant list.

After that recursive call returns, we come back to the previous recursive call. Then, we remove the last element from the current list because now we want to explore the other possibility,

which is excluding that element. We again make a recursive call and repeat the same process.

In this way, for every element, we explore both possibilities: including the element and excluding the element. We continue this process until all the recursive calls are completed, and finally, we get all possible subsets.

Time Complexity: O(n × 2ⁿ)
Space Complexity: 0(n)*/
