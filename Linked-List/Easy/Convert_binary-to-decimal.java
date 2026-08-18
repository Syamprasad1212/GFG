/* LinkedList Node structure
class Node {
    int data;   // data is either 0 or 1
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
};
*/
class Solution {
    public int decimalValue(Node head) {
        // code here
        Node temp=head;
        long num=0;
        long MOD=1000000007;
        while(temp!=null){
            num=(num*2+temp.data)%MOD;
            temp=temp.next;
        }
        return (int)num;
    }
};
