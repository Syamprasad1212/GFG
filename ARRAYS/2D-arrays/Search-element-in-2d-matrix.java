class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int m=mat.length;
        int n=mat[0].length;
        int l=0,h=n-1;

        while(l<m && h>=0){
            if(mat[l][h]==x){
                return true;
            }else if(mat[l][h]>x){
                h--;
            }else{
                l++;
            }
        }
        return false;
    }
}
/*In this problem, the matrix is sorted row-wise and column-wise, so I start from the top-right corner. This position helps me eliminate either a row or a column in every step.

If the current element is greater than the target, I move left because all elements below it will be even greater. If the current element is smaller than the target, I move down because all elements on the left will be smaller.

I keep doing this until I either find the target or go out of the matrix boundaries. By eliminating one row or one column at a time, I can search efficiently without checking every element.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/
