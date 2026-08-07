/* Node Structure
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node deleteMid(Node head) {
        // code here
        if(head==null || head.next==null){
            return null;
        }
       Node f=head;
       Node s=head;
       Node prev=head;

       while(f!=null && f.next!=null){
        prev=s;
        f=f.next.next;
        s=s.next;
       } 

       prev.next=s.next;
       s.next=null;
       return head;
    }
}
