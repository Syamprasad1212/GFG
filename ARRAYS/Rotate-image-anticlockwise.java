class Solution {
    public void rotateMatrix(int[][] mat) {
        int n=mat.length;
        for(int j=0;j<n/2;j++){
            for(int i=0;i<n;i++){
                int temp=mat[i][j];
                mat[i][j]=mat[i][n-j-1];
                mat[i][n-j-1]=temp;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
    }
}
/* In this problem we want to rotate array anticlockwise in order to do that we want to 1st reverse 
the columns 1st column and slash column and then we want to transpose the matrix to get the required array 
the reversal of column is done by simply entertaining the loop first take J loop then I loop and use it normally and transposing
we know it's simple but one thing to remember in the transpose is don't start ING at the zirak position start J at the I plus one position*/
