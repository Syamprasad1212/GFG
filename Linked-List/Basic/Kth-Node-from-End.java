/* Node Structure
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public int getKthFromLast(Node head, int k) {
        // code here
        Node temp=head;
        int cnt=1;
        while(temp.next!=null){
            cnt++;
            temp=temp.next;
        }
        
        if(k>cnt) return -1;
        Node temp2=head;
        
        int cnt2=cnt-k;
        
        while(cnt2!=0){
            cnt2--;
            temp2=temp2.next;
        }
        return temp2.data;
    }
}
