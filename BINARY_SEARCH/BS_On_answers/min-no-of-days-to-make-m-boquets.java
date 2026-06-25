class Solution {
    Boolean validOrNot(int []arr,int mid,int m,int k){
        int count=0,noOfBoq=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                count++;
            }else{
                noOfBoq+=(count/k);
                count=0;
            }
        }
        noOfBoq+=(count/k);
        if(noOfBoq>=m){
            return true;
        }
        return false;
    }
    public int minDaysBloom(int[] bloomDay, int k, int m) {
         int l=1,mid=0,n=bloomDay.length;
        int h=bloomDay[0];
        for(int f:bloomDay){
            h=Math.max(h,f);
        }
        if(n<(m*k)) return -1;
        int res=-1;
        while(l<=h){
             mid=l+(h-l)/2;

            boolean ans=validOrNot(bloomDay,mid,m,k);
            if(ans){
                res=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
}
