class Solution {
    
    static int power(int x,long n){
        if(n==0) return 1;

        if(n==1) return x;

        if(n%2==0){
            return power(x*x,n/2);
        }
        return x*power(x,n-1);
    }
    public int recursivePower(int n, int p) {
        long N=p;

        return power(n,N);
    }
}
