class Solution {
    public void mergeArrays(int a[], int b[]) {
        int n=a.length;
        int m=b.length;
         int c[]=new int[m+n];
        int i=0,j=0,k=0;
        while(i<n && j<m){
        if(a[i]<=b[j]){
            c[k]=a[i];
            i++;
            k++;
        }else if(b[j]<=a[i]){
            c[k]=b[j];
            j++;
            k++;
        }
        }   
        while(i<n){
            c[k]=a[i];
            i++;
            k++;
        }

        while(j<m){
            c[k]=b[j];
            j++;
            k++;
        }
        for(int x=0;x<n;x++){
            a[x]=c[x];
        }
        for(int y=0;y<m;y++){
            b[y]=c[y+n];
        }
    }
}
