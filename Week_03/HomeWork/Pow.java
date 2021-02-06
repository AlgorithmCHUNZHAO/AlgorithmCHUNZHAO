

// class Solution {
//     public double quickMul(double x,long N) {
//         if(N == 0) {
//             return 1.0;
//         }
//         double y = quickMul(x,N / 2);
//         return N % 2 == 0 ? y * y : y * y * x;
//     }
//     public double myPow(double x,int n) {
//         long N = n;
//         return N >= 0 ? quickMul(x,N) : 1.0 / quickMul(x,-N);
//     }
// }

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