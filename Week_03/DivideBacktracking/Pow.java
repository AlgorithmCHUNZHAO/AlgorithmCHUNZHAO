class Solution {
    double quickMul(double x,long N ) {
        double ans = 1.0;
        double x_contribute = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            N /= 2;
        }
        return ans;
    }
    public double myPow(double x,int n) {
        long N = n;
        return N >= 0 ? quickMul(x,N) : 1.0 / quickMul(x,-N);
    }
}

// public double myPow(double x, int n) {
//     if(n == 0) return 1;
//     if(n == Integer.MIN_VALUE){
//         x = x * x;
//         n = n/2;
//     }
//     if(n < 0) {
//         n = -n;
//         x = 1/x;
//     }
//     return (n%2 == 0) ? myPow(x * x, n/2) : x *  myPow(x * x, n/2);
// }