class Solution {
    int maxSubarraySum(int[] arr) {
    int sum=0,maxsum=Integer.MIN_VALUE;
    int n=arr.length;
    for(int i=0;i<n;i++){
        sum=sum+arr[i];
        if(sum>maxsum){
            maxsum=sum;
        }
        if(sum<0){
            sum=0;
        }
    }
        return maxsum;
}
}

