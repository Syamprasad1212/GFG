class Solution {
         static void swap(int arr[],int a , int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public void sort012(int[] arr) {
        int l=0,ite=0,r=arr.length-1;
        while(ite<=r){
            if(arr[ite]==0){
                swap(arr,ite,l);
                ite++;
                l++;
            }else if(arr[ite]==2){
                swap(arr,ite,r);
                r--;
            }else{
                ite++;
            }
        }
    }
}
/*This is a classical problem We want to solve this in order of N time complexity So in order to do that 
we are going to use the 2 pointer technique again We can take iterate element which iterate over the LA and 
scan the array and if we 0 we can swap with lower bound element and if we found two we can swap with higher bound 
element by that we arranged one in the between So this is the very simple technique only thing you have to remember is that increment the iterators right way in right time
We we don't need to increment the iterator when we swap right side element with iterator element because we 
update the iterator there there is a chance that we are end up with wrong positioning of the elements so it is very important to remember that thing*/
