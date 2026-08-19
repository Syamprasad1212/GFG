/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node headRef) {
        // code here
        Node temp=headRef;
        Node res=new Node(headRef.data);
        
        while(temp!=null){
            if(temp.next.data!=res.data){
               res=res.next;
                res.data=temp.next.data;
                temp=temp.next;
            }
        }
        return res;
    }
}
