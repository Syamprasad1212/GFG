class Solution {
    public boolean binarySearch(int[] arr, int k) {
        int n=arr.length;
        int l=0,h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==k){
                return true;
            }else if(k>arr[mid]){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return false;
    }
}
    
