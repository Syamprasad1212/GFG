class Solution {
    public String maxOdd(String num) {
      int n=num.length();
        String res="";

        for(int i=n-1;i>=0;i--){
            char ch=num.charAt(i);
            int digit=ch-'0';
            if(digit%2==1){
                res=num.substring(0,i+1);
                break;
            }
        }
        return res;
    }
}
