/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public int lengthOfLoop(Node head) {
         Node f=head;
        Node s=head;
        int count=0;

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
                        f=f.next;
                        count++;
                        while(s!=f){
                            f=f.next;
                            count++;
                        }
                        return count;
                    }
                }
            }
        }
        return 0;
    }
}




/*We use Floyd’s Cycle Detection Algorithm (Tortoise and Hare approach) to first detect whether a cycle exists in the linked list and then calculate the length of that cycle.

Two pointers, slow (s) and fast (f), are initialized at the head of the list. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.

If there is no cycle, the fast pointer will reach the end of the list (f == null or f.next == null), and we return 0, indicating no loop.

If a cycle exists, the fast and slow pointers will meet at some node inside the loop. Once they meet, we know a cycle is present.

To calculate the length of the loop, we keep one pointer fixed at the meeting point and move the other pointer step by step through the cycle. We increment a counter for each step until the pointer reaches the same node again. The total count represents the number of nodes in the loop.

This approach runs in O(n) time and uses O(1) extra space.*/
