/* Structure of linked list Node
class Node {
  public:
    int data;
    Node next;

    public Node(int x) {
        data = x;
        next = null;
    }
};
*/
class Solution{
Node deleteAtPosition(Node head, int pos) {
    // code here
    if(head == null) return null;

    if(pos == 1) {
        return head.next;
    }
    
    Node curr=head;
    
   for(int i=1;i<pos-1 && curr!=null;i++){
       curr=curr.next;
   }
   if(curr==null ||curr.next==null){
       return head;
   }
   curr.next=curr.next.next;
    return head;
}
}
