class Solution {
    public static void backtrack(int index,StringBuilder curr,ArrayList<String> sb,int[] digits,HashMap<Integer,String>map){
            if(index==digits.length){
                sb.add(curr.toString());
                return;
            }
            int dig=digits[index];
            if(dig==1 || dig==0){
                 backtrack(index+1,curr,sb,digits,map);
                 return;
            }
            String letters=map.get(dig);

            for(char ch:letters.toCharArray()){
                curr.append(ch);
                backtrack(index+1,curr,sb,digits,map);
                curr.deleteCharAt(curr.length()-1);
            }
        }

    public ArrayList<String> possibleWords(int[] arr) {
        int index=0;
               ArrayList<String>sb=new ArrayList<>();
               HashMap<Integer,String>map=new HashMap<>();
               map.put(2,"abc");
               map.put(3,"def");
               map.put(4,"ghi");
               map.put(5,"jkl");
               map.put(6,"mno");
               map.put(7,"pqrs");
               map.put(8,"tuv");
               map.put(9,"wxyz");
               backtrack(0,new StringBuilder(),sb,arr,map);
               return sb;
    }
}
