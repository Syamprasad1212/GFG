class Solution {
    public int firstSearch(int[] arr, int k) {
        // Code Here
        int n=arr.length;
        int l=0,h=n-1;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==k){
                if(mid==0){
                    return mid;
                }
                if(arr[mid-1]!=k){
                return mid;
                }
                else if(mid>=1){
                h=mid-1;
                }
            }else if(arr[mid]<k){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return -1;
    }
}
