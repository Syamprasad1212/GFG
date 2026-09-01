class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()) return;
        
        int curr=st.pop();
        reverseStack(st);
        putAtbottom(st,curr);
    }
    static void putAtbottom(Stack<Integer>st, int curr){
        if(st.isEmpty()){
            st.push(curr);
            return;
        }
        
        int temp=st.pop();
        putAtbottom(st,curr);
        st.push(temp);
    }
}



/*Approach (Reverse Stack Using Recursion)

We recursively pop all elements from the stack and store each popped element in curr. Once the stack becomes empty, while returning from recursion, we call putAtBottom() 

to insert each element at the bottom of the stack. In putAtBottom(), we keep popping the existing elements, insert curr when the stack becomes empty, and then push the removed elements back. This process reverses the complete stack without using another stack.

Intuition

Instead of pushing the popped element back to the top, we insert it at the bottom. Since the elements are processed in reverse order while returning from recursion, inserting them at the bottom produces the reversed stack.

Time Complexity

O(N²) — For every element, putAtBottom() may traverse the stack to reach the bottom, giving N + (N-1) + ... + 1 operations.

Space Complexity

O(N) — Recursion uses stack space for up to N elements.*/
