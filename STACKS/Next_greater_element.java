class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
       int n=arr.length;
       ArrayList<Integer>great=new ArrayList<>();
       Stack<Integer>st=new Stack<>();
       for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                great.add(0,-1);
            }else{
                great.add(0,st.peek());
            }
            st.push(arr[i]);
       }
        return great;
    }
}

