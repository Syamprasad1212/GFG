class Solution {
    static String removeChars(String str1, String str2) {
        // code here
        int count=0;
        StringBuilder sv=new StringBuilder();
        for(int i=0;i<str1.length();i++){
            count=0;
            for(int j=0;j<str2.length();j++){
                if(str2.charAt(j)!=str1.charAt(i)){
                    count++;
                }
                if(count==str2.length()){
                    sv.append(str1.charAt(i));
                    break;
                }
            }
        }
        return sv.toString();
    }
}
