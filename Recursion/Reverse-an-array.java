class Solution {
    static void reverse(int []arr,int l,int r){
        if(l>=r){
            return;
        }
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
        
        reverse(arr,++l,--r);
    }
    public void reverseArray(int arr[]) {
        int l=0,r=arr.length-1;
        
        reverse(arr,l,r);
    }
}
