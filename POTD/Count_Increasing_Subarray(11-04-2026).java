class Solution {
    public int countIncreasing(int[] arr) {
        // code here
        int count=0,curr=0;
        for(int i=0;i<arr.length;i++){
            curr=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(curr<arr[j]){
                    curr=arr[j];
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }
}
