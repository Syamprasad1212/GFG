class Solution {
    public static boolean search(char[][]board,String word,int m,int n,int i,int j, int k){
        if(word.length()==k){
            return true;
        }

        if(i<0||i==m||j<0||j==n||word.charAt(k)!=board[i][j]){
            return false;
        }

        char ch=board[i][j];
        board[i][j]='#';
       boolean o1= search(board,word,m,n,i+1,j,k+1);
        boolean o2=search(board,word,m,n,i,j+1,k+1);
        boolean o3=search(board,word,m,n,i-1,j,k+1);
        boolean o4=search(board,word,m,n,i,j-1,k+1);
        board[i][j]=ch;
        return o1||o2||o3||o4;
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board,word,m,n,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}



/*Approach (Backtracking)
Traverse every cell of the board and look for a cell matching the first character of the word.
When a matching cell is found, start the backtracking search from that cell.
At each recursive call:
If k == word.length(), the complete word has been found, so return true.
If the current cell is outside the board or its character does not match word[k], return false.
Mark the current cell as visited using '#' so that the same cell is not reused in the current path.
Recursively explore all 4 directions:
Down
Right
Up
Left
After exploring all directions, restore the original character. This is the backtracking step, allowing the cell to be used in another possible path.
If any of the four recursive calls returns true, return true; otherwise return false.
If no starting cell produces the word, return false.
Intuition

We try to build the word character by character starting from every possible matching cell.

At each cell, we have up to 4 choices for the next character. Before moving forward, we mark the current cell as visited so that we don't use the same cell twice in the same path. After finishing that path, we restore the cell to its original character so that other paths can use it.

The core backtracking pattern is:

Choose cell
    ↓
Mark visited
    ↓
Explore 4 directions
    ↓
Restore cell
    ↓
Try another path
Time Complexity

O(M × N × 4^L)

M × N → We may start the search from every cell.
4^L → For a word of length L, each character can potentially explore up to 4 directions.

More precisely, after the first move there are effectively at most 3 new directions because we cannot immediately reuse the previous cell, but O(M × N × 4^L) is the standard upper-bound expression.

Space Complexity

O(L) — The recursion depth can go up to the length of the word.

We modify the board in-place for the visited marking, so no separate M × N visited array is required.

L = word.length()*/
