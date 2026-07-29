/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode mahi=head;
        ListNode syammu=head;

        while(syammu!=null && syammu.next!=null){
            mahi=mahi.next;
            syammu=syammu.next.next;
            if(syammu==mahi) return true;
        }
        return false;
    }
}

/*We use Floyd's Cycle Detection Algorithm, also known as the Tortoise and Hare algorithm. Two pointers, slow and fast, start from the head. 
The slow pointer moves one step at a time, while the fast pointer moves two steps. If the linked list has a cycle, the fast pointer will eventually 
meet the slow pointer inside the cycle, so we return true. If the list has no cycle, the fast pointer reaches the end of the list (fast == null or fast.next == null), 
and we return false. This approach runs in O(n) time and uses O(1) extra space*/
