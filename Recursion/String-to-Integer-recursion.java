class Solution {
    static final int INT_MINVALUE=-2147483648;
    static final int INT_MAXVALUE=2147483647;
    static int myString(String s,int i,long num,int sign){
        int n=s.length();
        if(i>=n || !Character.isDigit(s.charAt(i))){
            return sign*(int)num;
        }

        num=num*10+(s.charAt(i)-'0');

        if(sign==1 && num>Integer.MAX_VALUE) return INT_MAXVALUE;
        if(sign==-1 && -num<Integer.MIN_VALUE) return INT_MINVALUE;

        return myString(s,i+1,num,sign);
    }
    public int myAtoi(String s) {
        int i=0;
        int n=s.length();
        if(n==0){
            return 0;
        }
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        int sign=1;

        if(i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign=(s.charAt(i)=='-')?-1:1;
            i++;
        }
        return myString(s,i,0,sign);
    }
}



/*In this recursive approach, we process the string from left to right. Since the string may contain leading spaces, a positive or negative sign, digits, and non-digit characters, 

starting from the beginning is more suitable. First, in myAtoi(), we skip all leading spaces and check for a + or - sign. By default, we initialize sign = 1, and if we encounter -, 
  we change it to -1. Then, we call the recursive helper function with the string, current index, current number initialized to 0, and the sign.

Inside the recursive function, the base case occurs when we reach the end of the string or encounter a non-digit character. In that case, we return sign * num. Otherwise, we build the number
  
using num = num * 10 + digit, check for overflow, and recursively move to the next index. Since num is stored as a positive value, for negative overflow we apply the sign first and check whether -num is smaller than Integer.MIN_VALUE.

The time complexity is O(N) because each character is processed at most once. The space complexity is O(N) because, in the worst case, there can be N recursive calls stored in the recursion stack.*/
