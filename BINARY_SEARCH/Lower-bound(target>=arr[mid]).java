class Solution {
    int lowerBound(int[] arr, int target) {
        int n=arr.length;
        int l=0,h=n-1,ans=n;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]>=target){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
        
    }
}
    
  
