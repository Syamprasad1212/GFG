/* Structure of Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        Node temp=head;
        
        while(temp!=null){
            if(temp.data==x){
                if(temp==head){
                    head=head.next;
                }
                
                if(temp.prev!=null){
                    temp.prev.next=temp.next;
                }
                
                if(temp.next!=null){
                    temp.next.prev=temp.prev;
                }
            }
            temp=temp.next;
        }
        return head;
    }
}


/*Approach

We traverse the doubly linked list using a temp pointer and delete every node whose value is equal to x.

If temp.data == x, check whether the node is the head and update head.
Connect the previous node to the next node using temp.prev.next = temp.next.
Connect the next node back to the previous node using temp.next.prev = temp.prev.
Move temp to the next node and continue until the list ends.
Code Pattern
if (temp.data == x) {
    if (temp == head)
        head = head.next;


    if (temp.prev != null)
        temp.prev.next = temp.next;


    if (temp.next != null)
        temp.next.prev = temp.prev;
}


temp = temp.next;
Time Complexity

O(N) — We traverse the linked list once, visiting each node exactly once.

Space Complexity

O(1) — Only the temp pointer is used; no extra data structures are required.*/
