//每天都有交易，股票要么买或者卖


class Solution {
    private int res;
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) {
            return 0;
        }
        this.res = 0;
        
        return this.res;
    }
    private void dfs(int[] prices,int index,int len,int status,int profit) {
        if(index == len) {
            this.res = Math.max(this.res,profit);
            return;
        }
        dfs(prices,index+1,len,status,profit);
        if(status == 0) {
            dfs(prices,index+1,len,1,profit-prices[index]);
        } else {
            dfs(prices,index+1,len,0,profit+prices[index]);
        }
    }
}
//动态规划
// public class Solution {
//     public int maxProfit(int[] prices) {
//         int len = prices.length;
//         if(len < 2) {
//             return 0;
//         }
//         //0:持现金
//         //1:持有股票
//         // 状态转移
//         int[][] dp = new int[len][2];
//         dp[0][0] = 0;
//         dp[0][1] = -prices[0];

//         for(int i = 1; i < len;i++) {
//             dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
//             dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
//         }
//         return dp[len - 1][0];
//     }
// }
// class Solution {
//     public int maxProfit(int[] prices) {
//         int len = prices.length;
//         if(len < 2) {
//             return 0;
//         }

//         int[] cash = new int[len];
//         int[] hold = new int[len];

//         cash[0] = 0;
//         hold[0] = -prices[0];
//         for(int i = 1; i < len;i++) {
//             cash[i] = Math.max(cash[i-1],hold[i-1] + prices[i]);
//             hold[i] = Math.max(hold[i-1],cash[i-1] - prices[i]);
//         }
//         return cash[len -1];
            
//     }
// }

// public class Solution {
//     public int maxProfit(int[] prices) {
//         int len = prices.length;
//         if(len < 2) {
//             return 0;
//         }
//         int res = 0;
//         for(in i = 1; i < len;i++) {
//             res += Math.max(prices[i] - prices[i-1],0);
//         }
//         return 0;
//     }
// }