class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(mat[i][j]==0)
                 {
                    rows[i]=true;
                    cols[j]=true;
                 }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rows[i]||cols[j]){
                    mat[i][j]=0;
                }
            }
        }

    }
}
/*In this particular question We want to If you find any zero in any of the row or column We want to make 
that entire row and column zeros Show hear the tricky part is if we do this It may change the array matrix elements 
So we gonna take a boolean array Of Rosen columns We gonna travel through the matrix If you found anywhere zero 
We just make that row and Boolean value is true And after that we can just cheque Any of the row or column is True true If it is true That means That particular row or column 1 to be zero we can just do it*/
