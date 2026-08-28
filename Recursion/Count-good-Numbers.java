class Solution {
    static final long MOD=1000000007L;
    static long pow(long n,long e){
        if(e==0){
            return 1;
        }
        if(e==1) return n;

        if(e%2==0){
            return pow((n*n)%MOD,e/2)%MOD;
        }
        return n*pow(n,e-1)%MOD;
    }
    public int countGoodNumbers(long n) {
        return (int)(pow(5,(n/2+n%2))*pow(4,(n/2))%MOD);
    }
}

/*Count Good Numbers – Approach

We know that every digit is in the range 0 to 9.
For even indices, there are 5 possible even digits: 0, 2, 4, 6, 8.
For odd indices, there are 4 possible prime digits: 2, 3, 5, 7.

So we can form the formula:

Even positions → 5^(n/2 + n%2)
Odd positions → 4^(n/2)

The final answer is:

5^(n/2 + n%2) × 4^(n/2) % (10^9 + 7)

To calculate the powers efficiently, we use recursive binary exponentiation. If the exponent is even, we square the base and divide the exponent by 2. If it is odd, we multiply by the base and reduce the exponent.

We continuously apply modulo 10^9 + 7 so that the numbers do not become extremely large. We only need the remainder, which is sufficient for the final answer.

Time Complexity

O(log n)

We calculate two powers, and each power takes O(log n) using binary exponentiation.

Space Complexity

O(log n)

Because the power function is recursive, the maximum recursion depth is O(log n).*/
