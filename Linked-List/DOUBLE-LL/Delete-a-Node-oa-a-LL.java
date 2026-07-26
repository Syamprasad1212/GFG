/* Structure of a Doubly Linked List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node delPos(Node head, int x) {
        // code here
        if(head==null)  return null;
        
        if(head.next==null){
            if(x==1){
                return null;
            }
            return head;
        }
        if(x==1 ){
            Node temp=head;
            head=head.next;
            temp.next=null;
            head.prev=null;
            return head;
        }
        Node temp=head;
        
        while(x>1 && temp!=null){
            x--;
            temp=temp.next;
        }
        
        if(temp==null) return head;
        
        Node prevv=temp.prev;
        Node nextt=temp.next;
        prevv.next=nextt;
        if(nextt!=null){
        nextt.prev=prevv;
        }
        temp.next=null;
        temp.prev=null;
        
        return head;
        
        
    }
}
