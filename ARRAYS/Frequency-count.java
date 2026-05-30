class Solution {
    public ArrayList<Integer> frequencyCount(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=arr.length;
        
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        ArrayList<Integer>ans=new ArrayList<>();
        HashSet<Integer>seen=new HashSet<>();
        
        for(int num:arr){
            if(!seen.contains(num)){
                ans.add(map.get(num));
                seen.add(num);
            }
        }
        return ans;
    }
}
