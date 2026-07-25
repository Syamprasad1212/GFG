/* Structure of doubly linked list node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        Node cnt=head;
        
        if(head.next==null || head==null) return head;
        
        while(cnt.next!=null){
            cnt=cnt.next;
        }
        
        Node st=head;
        
        while(st!=cnt && st.prev!=cnt){
            Node temp=new Node(cnt.data);
            cnt.data=st.data;
            st.data=temp.data;
            st=st.next;
            cnt=cnt.prev;
        }
        return head;
    }
}
