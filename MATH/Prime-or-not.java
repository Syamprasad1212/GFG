class Solution {
    static boolean isPrime(int n) {
        // code here
        boolean prime=n>=2;
        
        for(int i=2; i*i<=n;i++){
            if(n%i==0){
                prime=false;
                break;
            }
        }
        
        if(prime){
            return true;
        }
        return false;
    }
}
