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
    public ListNode findmiddle(ListNode h){
        ListNode s=h;
        ListNode f=h.next;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }

    public ListNode MergeSortList(ListNode list1, ListNode list2){
            ListNode dummy=new ListNode(-1);
            ListNode temp=dummy;

            while(list1!=null && list2!=null){
                if(list1.val<list2.val){
                    temp.next=list1;
                    temp=list1;
                    list1=list1.next;
                }else{
                    temp.next=list2;
                    temp=list2;
                    list2=list2.next;
                }
            }

            if(list1!=null){
                temp.next=list1;
            }else{
                temp.next=list2;
            }

            return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode middle=findmiddle(head);
        ListNode right=middle.next;
        middle.next=null;
        ListNode left=head;

        left=sortList(left);
        right=sortList(right);

        return MergeSortList(left,right);
    }
}

/*Approach

To sort the linked list efficiently, we use Merge Sort.

First, we divide the linked list into two halves. To find the middle node, we use the slow and fast pointer approach (implemented in a separate findMiddle() function). After finding the middle, we split the list into two parts and recursively sort both halves.

Once both halves become sorted, we call a separate merge function. In this function, we create a dummy node and use a temporary pointer to build the final sorted list. We compare the current nodes of both lists, attach the smaller node to the merged list, and continue until one list is exhausted. Finally, we attach the remaining nodes and return the merged sorted list.

Time Complexity

O(N log N)

At each recursive level, the linked list is divided into two halves.
There are log N levels of recursion.
At every level, all N nodes are processed once during the merge step.

Hence, the overall time complexity is O(N log N).

Space Complexity

O(log N)

No extra data structure is used to store the nodes.
The only extra space comes from the recursive call stack, which has a maximum depth of log N.*/
