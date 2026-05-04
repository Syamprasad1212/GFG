class Solution {
    public boolean isBinaryPalindrome(int n) {
        // code here
        String num=Integer.toBinaryString(n);
        int l=0;
        int r=num.length()-1;
       while(l<=r){
           if(num.charAt(l)!=num.charAt(r)){
        return false;
           }
           l++;
           r--;
       }
       return true;
    }
};
