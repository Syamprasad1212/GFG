class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
         int n=mat.length;
        int m=mat[0].length;
        int l=0,r=m-1;
        int top=0,bot=n-1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(top<=bot && l<=r){
        for(int i=l;i<=r;i++){
            ans.add(mat[top][i]);
        }
        top++;

        for(int i=top;i<=bot;i++){
            ans.add(mat[i][r]);
        }
        r--;
        if(top<=bot){

        for(int i=r;i>=l;i--){
            ans.add(mat[bot][i]);
        }
        bot--;
        }
        if(l<=r){
        for(int i=bot;i>=top;i--){
            ans.add(mat[i][l]);
        }
        l++;
        }
        }
        return ans;
    }
}
