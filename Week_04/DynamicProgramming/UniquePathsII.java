import jdk.nashorn.internal.ir.ReturnNode;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m+1][n+1];
        dp[1][1] = obstacleGrid[0][0]^1;
        for(int i = 1;i<=m;++i) {
            for(int j = 1;j <=n;++j) {
                if(obstacleGrid[i-1][j-1] == 0) 
                    dp[i][j] +=dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}


// class Solution1 {
//     int width = obstacleGrid[0].length;
//     int[] dp = new int[width];
//     dp[0] = 1;
//     for(int[] row: obstacleGrid) {
//         for(int j = 0; j < width;j++) {
//             if(row[j] == 1)
//                 dp[j] = 0;
//             else if(j > 0)
//                 dp[j] += dp[j-1];
//         }
//     }
//     return dp[width-1];
// }

class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
    
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)  {
                path[i][0] = 0;
                //on the first column, if there is an obstacle, the rest are blocked. 
                //no need to continue.
                break;  
            } else
                path[i][0] = 1;
        }
        
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1)  {
                path[0][j] = 0;
                //First row, once obstacle found, the rest are blocked.
                break; 
            } else
                path[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) 
                    path[i][j] = 0;
                else
                    path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }
}