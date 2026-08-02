class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int org=n;
        int reev=0;
        
        while(n!=0){
            int dig=n%10;
            reev=(dig*dig*dig)+reev;
            n=n/10;
        }
        if(reev==org){
            return true;
        }
        return false;
    }
}
