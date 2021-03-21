
// func climbStairs(n int) int{
// 	dp := make([]int,n+1)
// 	dp[0] = 1
// 	dp[1] = 1
// 	for i := 2; i < len(dp);i++ {
// 		dp[i] = dp[i-2] + dp[i-1]
// 	}
// 	return dp[n]
// }

package AdvancedSearch

// func climbStairs(n int) int {
// 	prev :=1
// 	cur :=1
// 	for i := 2; i < n+1;i++ {
// 		temp := cur;
// 		cur = prev + cur;
// 		prev = temp;
// 	}
// 	return cur
// }

func climbStairs(n int) int {
    prev, cur := 1,1
    for i := 0; i < n-1; i++ {
        prev, cur = cur, prev+cur
    }
    return cur
}



