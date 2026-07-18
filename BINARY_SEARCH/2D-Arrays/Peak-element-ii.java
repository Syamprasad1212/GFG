class Solution {
    public static int Maxrow(int mat[][],int n,int m, int mid){
       int row=0;
        for(int i=1;i<n;i++){
            if(mat[row][mid]<mat[i][mid]){
                row=i;
            }
        }
        return row;
    }
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        ArrayList<Integer>peak=new ArrayList<>();
        int l=0,h=m-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            int row=Maxrow(mat,n,m,mid);
            int left=(mid-1>=0)?mat[row][mid-1]:Integer.MIN_VALUE;
            int right=(mid+1<m)?mat[row][mid+1]:Integer.MIN_VALUE;

            if(left<=mat[row][mid] && right<=mat[row][mid]){
                peak.add(row);
                peak.add(mid);
                break;
            }else if(left>mat[row][mid]){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return peak;
    }
}

/*For the GFG version of the problem:

Use Integer.MIN_VALUE instead of -1 for imaginary boundary neighbors to correctly handle matrices containing negative values.
Use <= instead of < (and similarly >= instead of >, wherever applicable) because GFG may contain duplicate adjacent elements, whereas LeetCode guarantees all adjacent elements are different.*/
