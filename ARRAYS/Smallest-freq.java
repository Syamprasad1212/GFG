class Solution {
    public int maxRepeating(int k, int[] arr) {
        // code here
                int n=arr.length;
                HashMap<Integer,Integer>map=new HashMap<>();
                for(int i=0;i<n;i++){
                    map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                }
                int maxfreq=0;
                int res=Integer.MAX_VALUE;
               for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxfreq ||
                (entry.getValue() == maxfreq && entry.getKey() < res)) {

                maxfreq = entry.getValue();
                res = entry.getKey();
            }
        }

                return res;
    }
}
