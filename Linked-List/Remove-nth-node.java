class Solution {
    int getKthFromLast(Node head, int k) {
        Node s=head;
        Node f=head;

        for(int i=0;i<k;i++){
            if(f==null){
                return -1;
            }
            f=f.next;
        }
        while(f!=null){
            s=s.next;
            f=f.next;
        }


        return s.data;
    }
}
