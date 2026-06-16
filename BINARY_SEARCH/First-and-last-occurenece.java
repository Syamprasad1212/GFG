class Solution {
     int lowerBound(int[] arr, int target) {
        int n=arr.length;
        int ans=n;
        int l=0,h=n-1;
        
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
    
    int upperBound(int[] arr, int target) {
        int n=arr.length;
        int ans=n;
        int l=0,h=n-1;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]>target){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    
    ArrayList<Integer> find(int arr[], int x) {
        
        ArrayList<Integer>ans=new ArrayList<>();
        
        int first=lowerBound(arr,x);

        if(first==arr.length || arr[first]!=x){
            ans.add(-1);
            ans.add(-1);
            return ans;
        }

        int last=upperBound(arr,x)-1;
        
        ans.add(first);
        ans.add(last);

        return ans;
        
    }
}
