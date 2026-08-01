
class Solution {

    public long minMaxProduct(int[] arr1, int[] arr2) {
    int max=Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;
    for(int i=0;i<arr1.length;i++){
        if(arr1[i]>max){
            max=arr1[i];
        }
    }
    
    for(int i=0;i<arr2.length;i++){
        if(arr2[i]<min){
            min=arr2[i];
        }
    }
    int res=max*min;
        return res;
    }
}
