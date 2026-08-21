class Solution {
    public static int findSum(String s) {
        // code here
        int n=s.length();
        int sum=0,summ=0;
        for(int i=0;i<n;i++){
            if(Character.isDigit(s.charAt(i))){
                sum=sum*10+s.charAt(i)-'0';
            }else{
                summ+=sum;
                sum=0;
            }
        }
        if(Character.isDigit(s.charAt(n-1))){
        summ+=sum;
        }
        return summ;
    }
}
