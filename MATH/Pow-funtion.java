class Solution {
    double power(double b, int e) {
        
        long ee = e;
        double ans = 1.0;

        if (ee < 0)
            ee = -ee;

        while (ee > 0) {

            if (ee % 2 == 1) {
                ans = ans * b;
                ee--;
            } else {
                b = b * b;
                ee = ee / 2;
            }
        }

        if (e < 0)
            ans = 1.0 / ans;

        return ans;
    }
}
