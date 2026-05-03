class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        // code here
        Integer temp[]=new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp,(a,b)->
        Integer.bitCount(b)-Integer.bitCount(a)
        );
        ArrayList<Integer>result=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
             result.add(temp[i]);
        }
        return result;
}
}
