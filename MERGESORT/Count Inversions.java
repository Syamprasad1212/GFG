class Solution {
    static int MERGE(int []arr,int l,int mid,int u){
        int c[]=new int[u-l+1];
        int i=l,j=mid+1,inversion=0,k=0;
        while(i<=mid&&j<=u){
            if(arr[i]<=arr[j]){
                c[k]=arr[i];
                k++;
                i++;
            }else{
                c[k]=arr[j];
                k++;
                j++;
                inversion+=(mid-i+1);
            }
        }
        while(j<=u){
            c[k]=arr[j];
            j++;
            k++;
        }
        while(i<=mid){
            c[k]=arr[i];
            i++;
            k++;
        }
        for(int x=0;x<c.length;x++){
            arr[l+x]=c[x];
        }
        return inversion;
    }
    static int MERGESORT(int[] arr,int l,int u){
        int count=0;
        if(l<u){
          int mid=l+(u-l)/2;
         count+=MERGESORT(arr,l,mid);
          count+=MERGESORT(arr,mid+1,u);
          count+=MERGE(arr,l,mid,u);
        }
        return count;
    }
    static int inversionCount(int arr[]) {
        return MERGESORT(arr,0,arr.length-1);
        
    }
}
