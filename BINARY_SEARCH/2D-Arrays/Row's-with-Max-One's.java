class Solution {
    public int rowWithMax1s(int[][] mat) {
        // code here
         int n=mat.length;
        int m=mat[0].length;
        int maxcount=0,idx=-1;

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            if(count>maxcount){
                maxcount=count;
                idx=i;
            }else if(count==maxcount){
                if(idx>i){
                    maxcount=count;
                }
            }
        }
        return idx;
    }
};
