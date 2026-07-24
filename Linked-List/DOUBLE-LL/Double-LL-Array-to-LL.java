/* class Node {
    int data;
    Node next;
    Node prev;

    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
} */

class Solution {
    public Node createDLL(int arr[]) {
        Node head=new Node(arr[0]);
        Node prevv=head;
        
        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i]);
            prevv.next=temp;
            temp.prev=prevv;
            prevv=prevv.next;
        }
        return head;
    }
}
