//对于这类问题，采用深度优先搜索，由于题目可知，深度优先BFS的解法时间复杂度一般是O(n^2),
// 测试发现超时
// 通过O(n^2)将其时间复杂度降低，因此或许可以动态规划
class Solution {
    // public int jump(int[] nums) {
    //     int n = nums.length;
    //     int[] f = new int[n];
    //     for(int i = 1,j = 0;i < n;i++) {
    //         while(j+nums[j] < i)j++;
    //             f[i] = f[j] + 1;
    //     }
    //     return f[n-1];
    // }
    private int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > curFarthest) return -1;
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i < A.length-1 && i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}

