class Solution {
    public String convert(String s) {
        // code here
         String word[]=s.split("\\s+");
         int i=0;
         for(String n:word){
            word[i]=String.valueOf(Character.toUpperCase(n.charAt(0)))+n.substring(1);
            i++;
         }
        return String.join(" ",word);
    }
};
