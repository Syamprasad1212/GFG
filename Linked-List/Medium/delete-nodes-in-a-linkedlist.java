/* Structure of a linked list node
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}
*/
class Solution {

    public Node deleteAllOccurances(Node head, int x) {
        // code here
        Node temp=head;
        while(head!=null && head.data==x){
            head=head.next;
        }

        while(temp!=null && temp.next!=null){
            if(temp.next.data==x){
                temp.next=temp.next.next;
            }else{
            temp=temp.next;
            }
        }
        return head;
    }
}
