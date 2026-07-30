/*
class Node {
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
};
*/

class Solution {
    public int cycleStart(Node head) {
        // code here
        Node f=head;
        Node s=head;

        while(f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
            if(f==s){
                s=head;
                while(true){
                    if(s!=f){
                        s=s.next;
                        f=f.next;
                    }else if(s==f){
                        return s.data;
                    }
                }
            }
        }
        return -1;
    }
}
