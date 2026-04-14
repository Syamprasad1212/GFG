class Solution {
    String removeSpaces(String s) {
        // code here
        String ss=" ";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                ss+=s.charAt(i);
            }
        }
        return ss;
    }
}
