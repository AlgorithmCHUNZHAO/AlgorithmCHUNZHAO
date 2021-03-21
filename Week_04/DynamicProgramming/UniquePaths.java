class Solution {
    public int uniquePaths(int m,int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i< m;i++) {
            dp[i][0] = 1;
        }
        for(int i = 0; i < n;i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i < m;i++) {
            for(int j = 1;j < n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

class Solution1 {
    public int uniquePaths(int m,int n) {
        return uniquePathsHelper(m-1, n -1);
    }
    private int uniquePathsHelper(int m,int n) {
        if(m < 0 || n < 0) {
            return 0;
        } else if(m == 0 || n == 0) {
            return 1;
        } else {
            return uniquePathsHelper(m-1, n) + uniquePathsHelper(m, n-1);
        }
    }
}

class Solution2 {
    public int uniquePaths(int m,int n) {
        return uniquePathsHelper(m - 1, n -1,new int[n][m]);
    }
    private uniquePathsHelper(int m,int n,int[][] memo) {
        if(m < 0 || n < 0) {
            return 0;
        } else if (m == 0 || n == 0) {
            return 1;
        } else if(memo[m][n] > 0){
            return memo[n][m];
        } else {
            memo[n][m] = uniquePathsHelper(m-1, n,memo) + uniquePathsHelper(m, n-1,memo);
            return memo[n][m];
        }
    }
}