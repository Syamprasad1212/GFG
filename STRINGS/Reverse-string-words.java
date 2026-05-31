class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\.");
        ArrayList<String>arr=new ArrayList<>();
        
        for(String word:words){
            if(!word.isEmpty()){
                arr.add(word);
            }
        }
        int n=arr.size();
        int l=0,r=n-1;
        while(l<r){
            String temp=arr.get(l);
            arr.set(l,arr.get(r));
            arr.set(r,temp);
            l++;
            r--;
        }

        return String.join(".",arr);
    }
}
/*In this problem, we are given a string where words are separated by dots (.). The string may contain leading dots, trailing dots, 
or multiple consecutive dots. We need to reverse the order of the words without reversing the characters inside the words, and the final output should contain only a single dot between words.

First, we split the string using . as the delimiter. Since this can create empty strings due to extra dots, we ignore all empty strings and 
store only the valid words. Then, we reverse the order of the words using a two-pointer approach. Finally, we join the reversed words using a single dot (.) and return the resulting string.*/
