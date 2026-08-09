/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node reverse(Node temp){
        Node curr=temp;
        Node prev=null;
        
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public Node addOne(Node head) {
        head=reverse(head);
        Node temp=head;
        int carry=1;
        
        while(temp!=null){
            temp.data=temp.data+carry;
            if(temp.data<10){
                carry=0;
                break;
            }else{
                temp.data=0;
                carry=1;
            }
            temp=temp.next;
        }
        
        if(carry==1){
            Node neww=new Node(1);
            head=reverse(head);
            neww.next=head;
            return neww;
        }
        
            head=reverse(head);
            return head;
        
    }
}
