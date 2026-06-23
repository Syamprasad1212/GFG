class Solution {
    double multiple(double mid,double n){
        double ans=1.0;
        for(int i=1;i<=n;i++){
            ans=mid*ans;
        }
        return ans;
    }
    public int nthRoot(int n, int m) {
        int l=1;
        int h=m,ans=0;
        
        if(m==0) return 0;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            int pow=(int)multiple(mid,n);
            if(pow==m){
                return mid;
            }else if(pow>m){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}


/*For this problem, we can use Binary Search because there is a monotonic behavior. As the value of mid increases, the value of midⁿ also increases. This sorted nature allows us to efficiently eliminate half of the search space in every step.

We know that the nth root of m must lie in the range from 1 to m, so we initialize our search space as:

low = 1
high = m

For every iteration, we calculate the middle value mid. Then, using a separate helper function, we compute midⁿ and compare it with m.

If midⁿ == m, then we have found the exact nth root, so we return mid.
If midⁿ < m, then the current value is too small, and the required root must be on the right side. Therefore, we move low to mid + 1.
If midⁿ > m, then the current value is too large, and the required root must be on the left side. Therefore, we move high to mid - 1.

We continue this process until the search space becomes empty.

If the Binary Search completes and we never find a value such that midⁿ == m, it means that m does not have an integer nth root. In that case, we return -1.

Time Complexity
O(log m × n)

The Binary Search runs in O(log m) iterations, and in each iteration the helper function calculates midⁿ in O(n) time.

Space Complexity
O(1)

Since only a few variables are used and no extra space is required.*/
