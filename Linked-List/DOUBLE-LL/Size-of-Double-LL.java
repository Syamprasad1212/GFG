/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int a) {
        data = a;
        next = null;
        prev = null;
    }
} */

class Solution {
    public int findSize(Node head) {
        // Code Here
        Node temp=head;
        int cnt=0;
        
        while(temp!=null){
            temp=temp.next;
            cnt++;
        }
        return cnt;
        
    }
}
