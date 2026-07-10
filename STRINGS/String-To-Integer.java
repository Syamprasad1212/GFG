class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        long res=0;
        int i=0;
        int sign=1;

        while(i<n && s.charAt(i)==' '){
            i++;
        }

        if(i<n &&(s.charAt(i)=='+')){
            sign=1;
            i++;
        }else if(i<n && s.charAt(i)=='-'){
            sign=-1;
            i++;
        }

        while(i<n &&(s.charAt(i)!=0 && Character.isDigit(s.charAt(i)))){
            int digit=s.charAt(i)-'0';
            if(res>(Integer.MAX_VALUE-digit)/10){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE; //For some testcases its out of long range so i unexpectedly gives -ve so if somehow in process our res is crosses of integer ranges we just return here only the results  
            }else{
            res=res*10+digit;
            i++;
            }
        }
        res=res*sign;

        if(res>=Integer.MAX_VALUE){
            res=Integer.MAX_VALUE;
        }

        if(res<Integer.MIN_VALUE ){
            res=Integer.MIN_VALUE;
        }
        return (int)res;
    }
}


/*I first skipped all the leading whitespaces in the string. Then, I checked if the next character was an optional '+' or '-' sign and stored it in a sign variable.

Next, I started processing the digits one by one. For each digit, I converted it from a character to an integer and built the number using:

res = res * 10 + digit;

One of the main challenges in this problem is handling integer overflow. To avoid it, before updating the result, I checked whether multiplying the current result by 10 and 

adding the next digit would exceed the integer range. If an overflow was about to occur, I immediately returned Integer.MAX_VALUE for positive numbers or Integer.MIN_VALUE for negative numbers based on the stored sign.

I used a long variable to store the intermediate result so that normal integer calculations would not overflow while constructing the number. This also helped safely process values close to the integer

limits. After processing all valid digits, I applied the stored sign to the result.

Finally, as an extra safety check, I ensured that the final value was within the 32-bit signed integer range before returning it as an int.

T.c-O(n)*/
