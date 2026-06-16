class Solution {
    public int searchInsertK(int arr[], int k) {
         int n=arr.length;
        int ans=n;
        int l=0,h=n-1;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]>=k){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
};