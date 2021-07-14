/*

fib(n) = fib(n-1) + fib(n-2)
fib(0) = 0
fib(1) = 1

*/




class Solution {

    int fib(int n) {
        if(n <= 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fib(n-2) + fib(n-1);
        }
    }

    int fib1(int n,int[] memo) {
        if(n <=1) {
            return n;
        }
        if(memo[n] == 0) {
            memo[n] = fib(n-1) + fib(n-2);
        }
        return memo[n];
    }
}

/*
int fib(int n) {
    return n <= 1 ? n : fib(n-1) + fib(n-2)
}
*/




