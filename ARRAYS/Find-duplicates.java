class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer>res=new ArrayList<>();

        for(int key:map.keySet()){
            if(map.get(key)>1){
                res.add(key);
            }
        }
        return res;
    }
}
