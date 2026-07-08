class Solution {
    public int maxDepth(String s) {
        int n=s.length(),count=0,Maxcount=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                count++;
                Maxcount=Math.max(count,Maxcount);
            }else if(s.charAt(i)==')'){
                count--;
            }
        }
        return Maxcount;
    }
}

/*Since the given string is a valid parentheses string, we can track the current nesting depth using a counter.

Traverse each character in the string.
Whenever we encounter an opening parenthesis '(', increment the current depth.
After incrementing, compare the current depth with the maximum depth seen so far and update the maximum if needed.
Whenever we encounter a closing parenthesis ')', decrement the current depth, as we are moving out of one level of nesting.
Continue this process until the end of the string.
Finally, return the maximum depth that was recorded during the traversal.
Time Complexity
O(n) — We traverse the string exactly once.
Space Complexity
O(1) — We use only two integer variables (currentDepth and maxDepth), regardless of the input size.*/
