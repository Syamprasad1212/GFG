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
        Node temp=head;
        
        int one=0,two=0,zero=0;
        
        while(temp!=null){
            if(temp.data==0){
                zero++;
            }else if(temp.data==1){
                one++;
            }else{
                two++;
            }
            temp=temp.next;
        }
        
        temp=head;
        
            
            while(zero!=0){
                temp.data=0;
                zero--;
                temp=temp.next;
            }
            
             while(one!=0){
                temp.data=1;
                one--;
                temp=temp.next;
            }
            
             while(two!=0){
                temp.data=2;
                two--;
                temp=temp.next;
            }
        
        return head;
        
    }
}


/*The brute-force approach is to store all the linked list values in an array, sort the array, and then put the sorted values back into the linked list.

To optimize this, since the list contains only 0, 1, and 2, we don't actually need to sort.

Traverse the linked list once and count the number of 0s, 1s, and 2s.
Traverse the list again and overwrite the node values according to those counts.
First place all 0s, then all 1s, and finally all 2s.

This gives us a sorted linked list without using any extra data structure.

Time Complexity

O(N) — We traverse the linked list twice, so O(N) + O(N) = O(N).

Space Complexity

O(1) — Only three integer counters (zero, one, two) and a pointer are used; no extra array or linked list is created.*/
