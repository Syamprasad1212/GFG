class Solution {
    
    public static void combinations(int idx,int []arr,int t,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> res){
            int n=arr.length;
                if(t==0){
                    ans.add(new ArrayList<>(res));
                return;
                }

                for(int i=idx;i<arr.length;i++){
                    if(i>idx && arr[i]==arr[i-1]) continue;
                    if(arr[i]>t) break;
                res.add(arr[i]);
                combinations(i+1,arr,t-arr[i],ans,res);
                res.remove(res.size()-1);
                } 

        }
    public ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        // code here
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
                Arrays.sort(arr);
               combinations(0,arr,target,ans,new ArrayList<>());
               return ans;
    }
}

/*In this problem, we need to find all possible combinations whose sum is equal to the target. Each element can be used only once, and duplicate combinations are not allowed.

First, we sort the array so that duplicate elements come together and we can easily skip them.

Then, we recursively call the combinations() function. The base case is when our target becomes 0. At that point, we have found a valid combination, so we add a copy of the current list to our result.

Inside the loop, we check:

if(i > idx && arr[i] == arr[i-1])

This means that if the current element is the same as the previous element at the same recursion level, we skip it. This prevents generating duplicate combinations.

We then take the current element, add it to our current list, and recursively call the function with i + 1. Using i + 1 is important because every element can be used only once.

Since the array is sorted, if arr[i] > t, we can break the loop because all the elements after it will also be greater than the remaining target.

Finally, after the recursive call, we remove the last element to backtrack and try the next possible element.*/
