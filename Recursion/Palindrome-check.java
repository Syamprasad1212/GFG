class Solution {
    static boolean pal(String s , int f){
        int n=s.length();
        if(f>=n/2){
            return true;
        }
        if(s.charAt(f)!=(s.charAt(n-f-1))){
            return false;
        }
        
        return pal(s,f+1);
    }
    boolean isPalindrome(String s) {
        return pal(s,0);
    }
}
