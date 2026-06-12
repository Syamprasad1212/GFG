class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        int n=arr.length;
        Set<ArrayList<Integer>>res=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                HashSet<Integer>set=new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long sum=(long)arr[i]+arr[j];
                    sum+=arr[k];
                    long four=target-sum;
                    if(four>=Integer.MIN_VALUE && four<=Integer.MAX_VALUE && set.contains((int)four)){
                        ArrayList<Integer>temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add((int)four);
                        Collections.sort(temp);
                        res.add(temp);
                    }
                    set.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(res);
     }
}
/*For the brute-force solution, we would normally use four nested loops to generate all possible quadruplets, which would take O(n⁴) time.

To optimize it, we fix the first three elements using three loops. Instead of using a fourth loop to find the last element, we use a mathematical observation. If we already know the first three elements, then the required fourth element can be calculated as:

required = target - (nums[i] + nums[j] + nums[k])

Now the problem reduces to checking whether this required element exists among the elements we have already seen. To do that efficiently, we use a HashSet. The HashSet stores the elements encountered for the current (i, j) pair, allowing us to check for the required fourth element in O(1) average time.

Whenever the required element is found in the HashSet, we have discovered a valid quadruplet. We store the four elements in a temporary list and sort it so that the same quadruplet always has a consistent order.

To avoid duplicate quadruplets in the final answer, we use a HashSet of Lists. Since a quadruplet can be formed in different orders, sorting each quadruplet before insertion ensures that identical quadruplets look the same, and the HashSet automatically removes duplicates.

Finally, we convert the HashSet into a List and return the result.

Time Complexity: O(n³)

Space Complexity: O(n) for the HashSet used during the search, excluding the space required for storing the final answer.
*/
