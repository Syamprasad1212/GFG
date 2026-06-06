 class Solution {
     static void MERGE(int[] arr, int l, int mid, int u) {
        int[] c = new int[u - l + 1];
        int i = l, j = mid + 1, k = 0;

        while (i <= mid && j <= u) {
            if (arr[i] <= arr[j]) {
                c[k++] = arr[i++];
            } else {
                c[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            c[k++] = arr[i++];
        }

        while (j <= u) {
            c[k++] = arr[j++];
        }

        for (int x = 0; x < c.length; x++) {
            arr[l + x] = c[x];
        }
    }

    static int countpairs(int []arr,int low,int mid,int high ){
        int right=mid+1;
        int count=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && arr[i]>2L*arr[right]){
                right++;
            }
            count+=(right-(mid+1));
        }
        return count;
    }
    static int MERGESORT(int[] arr, int l, int u) {
        int count=0;
        if (l < u) {
            int mid = l + (u - l) / 2;

            count+=MERGESORT(arr, l, mid);
            count+=MERGESORT(arr, mid + 1, u);
            count+=countpairs(arr,l,mid,u);
            MERGE(arr, l, mid, u);
        }
         return count;
    }


    public int countRevPairs(int[] arr) {
        int n=arr.length;
        return MERGESORT(arr,0,n-1);
        
    }
}
