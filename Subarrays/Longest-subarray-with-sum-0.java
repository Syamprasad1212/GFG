class Solution {
    int maxLength(int arr[]) {
       int n=arr.length;
       HashMap<Integer,Integer>map=new HashMap<>();
       int maxlen=0,sum=0;
       
       for(int i=0;i<n;i++){
           sum+=arr[i];
           
           if(sum==0){
               maxlen=i+1;
           }
           
           if(map.containsKey(sum)){
               maxlen=Math.max(maxlen,i-map.get(sum));
           }else{
               map.put(sum,i);
           }
       }
       return maxlen;
    }
}

/*In this problem, we use a HashMap to store prefix sums and their first occurrence indices. As we traverse the array, we keep calculating the prefix sum at every position.

If the current prefix sum is already present in the HashMap, it means the sum of all elements between the previous occurrence and the current index is 0. We calculate the length of this subarray and update the maximum length if it is larger than the current answer.

If the prefix sum is not present in the HashMap, we store it along with its index. We continue this process until we reach the end of the array. The maximum length stored during the traversal is our final answer.

**Important Pattern to Remember:**

* Whenever you see a problem involving **subarray sum**, think about **prefix sums**.
* If you need to find the **longest subarray**, store the **first occurrence** of a prefix sum.
* If you need to find the **count of subarrays**, store the **frequency** of prefix sums.
* Repeated prefix sums often indicate that the sum of elements between them satisfies some condition (here, sum = 0).*/
