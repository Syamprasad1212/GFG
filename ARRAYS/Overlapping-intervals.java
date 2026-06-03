class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        
         Arrays.sort(arr,(a,b)->a[0]-b[0]);
         
        ArrayList<int[]>ans=new ArrayList<>();
        ans.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            int[] last=ans.get(ans.size()-1);
            if(last[1]>=arr[i][0]){
                last[1]=Math.max(last[1],arr[i][1]);
            }else{
                ans.add(arr[i]);
            }
        }
        return ans;
    }
}
