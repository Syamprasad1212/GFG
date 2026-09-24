class Solution {
    public static boolean solve(int node,int[][]edges,int m,int len,int []col){
        if(node==len){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(poss(node,edges,col,i)){
            col[node]=i;
            if(solve(node+1,edges,m,len,col)){
                return true;
            }
             col[node]=0;
            }
        }
        return false;
    }
    
    public static boolean poss(int node,int[][] edges,int[] col,int color){
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(u==node && col[v]==color){
                return false;
            }
            if(v==node && col[u]==color){
                return false;
            }
        }
        return true;
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        int len1=v;
        int col[]=new int[v];
        return solve(0,edges,m,len1,col);
        
    }
}


/*In this graph-coloring problem, we are given the number of vertices, the edges of the graph, and the maximum number of colors we can use.

First, we create a col[] array to keep track of which color is assigned to each vertex. Initially, all vertices have color 0, meaning no color has been assigned.

Then we use recursion to process the vertices one by one.

At every vertex, we try each available color from 1 to m. Before assigning a color, we use the poss() helper function to check whether that color can be safely assigned to the current vertex.

The poss() function checks all the edges and makes sure that none of the adjacent vertices already has the same color.

If the color is valid, we assign it to the current vertex and recursively move to the next vertex.

If the recursive call returns true, it means we successfully colored the entire graph, so we return true.

If that choice does not lead to a solution, we perform backtracking by resetting the current vertex's color back to 0 and trying the next color.

Finally, if node == len, it means all vertices have been successfully colored, so we return true.

If none of the available colors work for a vertex, we return false and backtrack to the previous vertex.*/
