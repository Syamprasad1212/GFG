/* Structure of Doubly Linked List Node
class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}; */

class Solution {
    public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) {
        // code here
        Node right=head;
        
        while(right!=null && right.next!=null){
            right=right.next;
        }
        Node left=head;
        
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        
        while(left!=right && left.prev!=right){
            int sum=left.data+right.data;
            if(sum==target){
                ArrayList<Integer>res1=new ArrayList<>();
                res1.add(left.data);
                res1.add(right.data);
                left=left.next;
                right=right.prev;
                res.add(res1);
                }else if(sum<target){
                    left=left.next;
                }else{
                    right=right.prev;
                }    
            
        }
    return res;
}
}


/*Initially, the brute-force approach is to check every possible pair and find whether their sum is equal to the target. If we find a pair, we store it in an ArrayList,

and finally we store all those pairs in another list. This is a brute-force approach because we are checking every possible combination, so the time complexity is O(n²).

To optimize this, we have to observe one important thing: the given doubly linked list is sorted. Because it is sorted and also doubly linked, we can use the two-pointer approach.

First, I take one pointer, left, at the starting of the linked list, and another pointer, right, at the end of the linked list. Then I compare left.data + right.data with the target.

If the sum is equal to the target, we found a pair, so we store it. Then we move both pointers — left forward and right backward.

If the sum is less than the target, we need a bigger value. Since the list is sorted, we move the left pointer forward because moving left forward gives us bigger values.

If the sum is greater than the target, we need a smaller value. So we move the right pointer backward because the previous values are smaller.

We continue this process until both pointers meet or cross each other. In this way, we don't have to check every possible pair.

So the time complexity becomes O(n) because we are traversing the list only a constant number of times, and the auxiliary space complexity is O(1) because we are only using two pointers.

The space required for storing the output pairs is O(k), where k is the number of pairs found.*/
