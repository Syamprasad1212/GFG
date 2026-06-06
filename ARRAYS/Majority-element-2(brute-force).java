class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        int n=arr.length;
        for(int key:map.keySet()){
            int num=map.get(key);
            if(num>n/3){
                ans.add(key);
            }
        }
        Collections.sort(ans);
        return ans;
    
    }
}
