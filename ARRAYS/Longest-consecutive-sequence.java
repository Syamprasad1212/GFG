class Solution {

    public int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int n=arr.length,maxcount=0;
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        for(int num:set){

        if(!set.contains(num-1)){
           int val=num;
           int count=1;
            while(set.contains(val+1)){
                    val++;
                    count++;
                }   
                maxcount=Math.max(maxcount,count);
            }
        }
        return maxcount;
    }
}
