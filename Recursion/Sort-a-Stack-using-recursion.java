class Solution {
    public void sortStack(Stack<Integer> st) {
        if(st.isEmpty()) return;
        
        int curr=st.pop();
        
        sortStack(st);
        
        insert(st,curr);
    }
    
    static void insert(Stack<Integer>st, int curr){
        if(st.isEmpty() || st.peek()<curr){
            st.push(curr);
            return;
        }
        
        int temp=st.pop();
        insert(st,curr);
        st.push(temp);
    }
}

/*Sort Stack Using Recursion

First, we check if the stack is empty. If it is empty, we return. Otherwise, we pop the top element and store it in curr, then recursively call sortStack() again. We keep doing this until the stack becomes empty.

When the stack becomes empty, the base case returns. After the recursive call returns, execution continues from the next statement, which is insert(st, curr).

The insert() function checks whether the stack is empty or st.peek() < curr. If either condition is true, we push curr and return.

Otherwise, we pop the top element into temp and recursively call insert() again. Once curr reaches its correct position, the recursive calls return one by one, and we push the stored temp elements back.

This gives us the stack with the largest element on top.

6 7 18 5  →  18 7 6 5
 ↑ top          ↑ top

Time Complexity: O(n²)
Space Complexity: O(n) — recursion call stack.

Key recursion flow:

sortStack()
   ↓
pop curr
   ↓
sortStack() → ... → empty → return
   ↓
insert(curr)
   ↓
return → continue previous call*/
