class Solution {
    public int longestCommonSubsequence(String text1,String text2) {
        int m = text1.length(),n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m;i++) {
            for(int j = 0;j < n;j++) {
                char c1 = text1.charAt(i),c2 = text2.charAt(j);
                if(c1 == c2) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[m][n];
    }
}

