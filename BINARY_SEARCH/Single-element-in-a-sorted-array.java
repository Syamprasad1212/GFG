class Solution {
    int single(int[] arr) {
         int n=arr.length;

        if(n==1) return arr[0];

        if(arr[0]!=arr[1]) return arr[0];

        if(arr[n-1]!=arr[n-2]) return arr[n-1];

        int l=1,h=n-2,mid=0;

        while(l<=h){
             mid=l+(h-l)/2;

             if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                 return arr[mid];
                }

            if(arr[mid]==arr[mid-1]){
                if(mid%2!=0){           // for left side index check
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
            else if(arr[mid]==arr[mid+1]){
                if(mid%2==0){           //for right side  index check
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }

        }
        return arr[mid];
    }
}
