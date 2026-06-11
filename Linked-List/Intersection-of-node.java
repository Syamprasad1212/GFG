/* structure of list node:

class Node
{
    int data;
    Node next;
    Node(int val)
    {
        data=val;
        next=null;
    }
}

*/

class Solution {
    public Node findIntersection(Node head1, Node head2) {
        Node temp=head2;
        HashSet<Integer>set=new HashSet<>();
        
        while(temp!=null){
            set.add(temp.data);
            temp=temp.next;
        }
        
        Node dummy=new Node(0);
        Node tail=dummy;
        temp=head1;
        
        while(temp!=null){
            if(set.contains(temp.data)){
                tail.next=new Node(temp.data);
                tail=tail.next;
            }
            temp=temp.next;
        }
        return dummy.next;
        
    }
}
