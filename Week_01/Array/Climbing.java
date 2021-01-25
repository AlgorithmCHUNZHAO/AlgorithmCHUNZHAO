//one solution: recursion

// n is small
class Solution {
    public static int climbStairs(int n) {
        if (n <=1)
            return 1;
        if (n < 3)
            return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
//n is big
class Solution {
    public static int climbStairs(int n) {
        return Fibonacci(n,1,1);
    }
    public static int Fibonacci(int n,int a,int b) {
        if (n <=1)
            return b;
        return Fibonacci(n - 1,b,a + b);
    }
}
//no recursion

class Solution {
    public int climbStairs(int n) {
        if (n <=1)
            return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3;i <=n;i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
//
class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int first = 1, second = 2, sum = 0;
        while (n-- > 2) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }









