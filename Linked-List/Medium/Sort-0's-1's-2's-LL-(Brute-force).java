/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        Node temp=head;
        
        ArrayList<Integer>map=new ArrayList<>();
        
        while(temp!=null){
            map.add(temp.data);
            temp=temp.next;
        }
        
        map.sort(null);
        
        temp=head;
        int i=0;
        while(temp!=null){
            temp.data=map.get(i);
            temp=temp.next;
            i++;
        }
        
        return head;
    }
}
