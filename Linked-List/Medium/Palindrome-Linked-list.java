/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode f=head;
        ListNode s=head;

        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }

        ListNode prev=null;
        ListNode curr=s;
        while(curr!=null){
            ListNode nextt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextt;

        }

        ListNode it=head;
        ListNode it2=prev;
        while(it2!=null){
        if(it.val!=it2.val){
            return false;
        }
        it=it.next;
        it2=it2.next;
        }

        return true;

    }
}

/*Use the Slow and Fast Pointer technique to find the middle of the linked list. Reverse the second half of the list and compare it with the first half. If all corresponding nodes are equal, return true; otherwise, return false.

Algorithm
Find the middle using slow and fast pointers.
Reverse the second half of the linked list.
Compare the first half with the reversed second half.
If all nodes match, return true; otherwise, return false.
Time Complexity
Finding middle: O(n)
Reversing second half: O(n)
Comparing both halves: O(n)

Overall: O(n)

Space Complexity

Only a few pointers are used.

O(1)*/
