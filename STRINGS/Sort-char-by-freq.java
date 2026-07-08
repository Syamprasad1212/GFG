class Solution {
    public String frequencySort(String s) {
        // code here
         int n=s.length();
         if(n==1) return s;

        HashMap<Character,Integer>map=new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        // just for checking frequency of characters

        List<Character>[]bucket=new ArrayList[n+1];
        //using bucket sort 

        for(char ch:map.keySet()){
            int freq=map.get(ch);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>(); //based on the freq adding ele to buckets same as freq and bucket number
            }

            bucket[freq].add(ch);
        }

        StringBuilder sb=new StringBuilder();//traverse bucket for required freq string

        for(int i=0;i<bucket.length-1;i++){
            if(bucket[i]==null) continue;
            Collections.sort(bucket[i]);// for same freq elements added in alpha order

            for(char ch:bucket[i]){
                for(int j=0;j<i;j++){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
};
