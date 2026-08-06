/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
         HashMap<Node,Integer>map=new HashMap<>();

        Node temp1=head1;

        while(temp1!=null){
            map.put(temp1,1);
            temp1=temp1.next;
        }

        temp1=head2;
        while(temp1!=null){
            if(map.containsKey(temp1)){
                return temp1;
            }
            temp1=temp1.next;
        }
        return null;
    }
}
