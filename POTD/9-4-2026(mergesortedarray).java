class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        // code here
        HashSet<Integer>set=new HashSet<>();
         HashSet<Integer>result=new HashSet<>();
         for(int s:a){
             set.add(s);
         }
         
         for(int s:b){
             if(set.contains(s)){
                 result.add(s);
             }
         }
         ArrayList<Integer> ans = new ArrayList<>(result);
         Collections.sort(ans);
         return ans;
    }
}
