class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length(),c=0;
        StringBuilder res=new StringBuilder();

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                if(c!=0){
                    res.append(s.charAt(i));
                }
                c++;
            }else if(s.charAt(i)==')'){
                c--;
                if(c!=0){
                    res.append(s.charAt(i));
                }
            }
        }
        return res.toString();
    }
}




/*My first thought was to solve this problem using a Stack, since matching parentheses is a common stack-based problem. However, after understanding the problem statement clearly, I realized that we don't 

actually need to store the parentheses. We only need to know whether the current parenthesis belongs to the outermost pair or an inner pair.

So, instead of using a stack, I use a counter to keep track of the current nesting depth.

Whenever I encounter '(', I first check whether the counter is greater than 0. If it is, this parenthesis is not the outermost one, so I add it to the result. Then I increment the counter.
Whenever I encounter ')', I first decrement the counter because we are leaving one level of nesting. After decrementing, if the counter is still greater than 0, this closing parenthesis belongs to an inner level, 
so I add it to the result. If the counter becomes 0, it means this is the outermost closing parenthesis, so I skip it.

By using the nesting depth instead of a stack, we achieve the same result while using constant extra space.

Time Complexity
O(n)
We traverse the string exactly once.
Space Complexity
O(1)*/
