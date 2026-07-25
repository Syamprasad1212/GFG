/* Structure of Doubly Linked List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/

class Solution {
    Node insertAtPos(Node head, int p, int x) {
        // code here
        if(head==null) {
            Node temp=new Node(x);
            head=temp;
         return head;   
        }
        Node p1=head;
        Node p2=head;
        
        while(p>0 && p1.next!=null){
            p1=p1.next;
            p--;
        }
        Node temp=new Node(x);
        
        if(p1.next!=null){
            p2=p1.next;
            p1.next=temp;
            p2.prev=temp;
            temp.next=p2;
            temp.prev=p1;
        }else {
            p1.next=temp;
            temp.prev=p1;
            temp.next=null;
        }
        return head;
    }
}
