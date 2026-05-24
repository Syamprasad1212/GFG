class Solution {
    static void reverse(int arr[],int left,int right){
        while(left<right){
            
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            
            left++;
            right--;
        }
    }
    void nextPermutation(int[] arr) {
        int n=arr.length;
        int piv=-1;
        
        for(int i=n-2;i>=0;i--){
            
            if(arr[i]<arr[i+1]){
                piv=i;
                break;
            }
        }
            
            if(piv==-1){
                
                reverse(arr,0,n-1);
                return;
            }
            
            for(int i=n-1;i>=0;i--){
                if(arr[i]>arr[piv]){
                int temp=arr[i];
                arr[i]=arr[piv];
                arr[piv]=temp;
                
                break;
                }
            }
        reverse(arr,piv+1,n-1);
        
    }
}
