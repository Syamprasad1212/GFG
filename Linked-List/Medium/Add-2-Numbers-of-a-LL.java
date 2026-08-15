/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node reverse(Node l1){
        Node curr=l1;
        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    Node removeZeroes(Node head){
        while(head!=null&&head.data==0&&head.next!=null){
            head=head.next;
        }
        return head;
    }
    public Node addTwoLists(Node l1, Node l2) {
        if(l1==null&&l2==null){
            return new Node(0);
        }
        // code here
        l1=reverse(l1);
        l2=reverse(l2);
        Node dum=new Node(0);
        Node cur=dum;
        int carry=0;
        int sum=0;
        while(l1!=null || l2!=null||carry!=0){
            sum=carry;
            if(l1!=null){
                sum+=l1.data;
                l1=l1.next;
            }

            if(l2!=null){
                sum+=l2.data;
                l2=l2.next;
            }
            cur.next=new Node(sum%10);
            cur=cur.next;
            carry=sum/10;
        }
        Node rev=reverse(dum.next);
        return removeZeroes(rev);
    }
}
