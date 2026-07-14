class Solution {
    // Function for adding one to the number represented by the array
    Vector<Integer> addOne(int[] arr) {
        // code here
        int n=arr.length;
        
        for(int i=n-1;i>=0;i--){
            if(arr[i]<9){
                arr[i]+=1;
                break;
            }else{
                arr[i]=0;
            }
        }
        
        Vector <Integer> ans=new Vector<>();
        if(arr[0]==0){
            ans.add(1);
            for(int i=0;i<n;i++){
                ans.add(0);
            }
            return ans;
        }
        
        int i=0;
        
        while(i<n && arr[i]==0){
            i++;
        }
        
        while(i<n){
            ans.add(arr[i]);
            i++;
        }
        return ans;
    }
}
