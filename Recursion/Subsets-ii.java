class Solution {
    
    public static void ress(int nums[],ArrayList<ArrayList<Integer>>res,ArrayList<Integer>curr,int start){
           res.add(new ArrayList<>(curr));
           for(int i=start;i<nums.length;i++){
               if(i>start && nums[i]==nums[i-1]) continue;
               curr.add(nums[i]);
                ress(nums,res,curr,i+1);
               curr.remove(curr.size()-1);
           }

       }
    public ArrayList<ArrayList<Integer>> findSubsets(int[] nums) {
             Arrays.sort(nums);
             ArrayList<ArrayList<Integer>>res=new ArrayList<>();
             ress(nums,res,new ArrayList<>(),0);
             return res;
}

}
