// class Solution {

//         private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//         private boolean[][] visited;
//         private int rows;
//         private int cols;
//         private char[][] grid;


//         public int numIslands(char[][] grid) {
//             rows = grid.length;
//             if(rows == 0) {
//                 return 0;
//             }
//             cols = grid[0].length;
//             this.grid = grid;
//             visited = new boolean[rows][cols];
//             int count = 0;
//             for(int i = 0; i < rows;i++) {
//                 for(int j = 0;j < cols;j++) {
//                     if(!visited[i][j] && grid[i][j] == '1') {
//                         dfs(i,j);
//                         count++;
//                     }
//                 }
//             }
//             return count;
//         }

//         //坐标为（i，j）的点开始深度优先遍历
//          private void dfs(int i,int j) {
//             visited[i][j] = true;
//             for(int k = 0;k < 4;k++) {
//                 int newX = i + DIRECTIONS[k][0];
//                 int newY = j + DIRECTIONS[k][1];
//                 if(inArea(newX,newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
//                     dfs(newX,newY);
//                 }
//             }
//         }

//         private boolean inArea(int x,int y) {
//             return x >= 0 && x < rows && y >=0 && y < cols;
//         }
// }

// import java.util.LinkedList;
// import java.util.Queue;

// public class Solution {

//     private final static int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//     private int rows;
//     private int cols;
//     private char[][] grid;
//     private boolean[][] visited;

//     public int numIslands(char[][] grid) {
//         rows = grid.length;
//         if (rows == 0) {
//             return 0;
//         }
//         cols = grid[0].length;
//         this.grid = grid;
//         visited = new boolean[rows][cols];

//         int count = 0;
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 if (!visited[i][j] && grid[i][j] == '1') {
//                     bfs(i, j);
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }

//     private void bfs(int i, int j) {
//         Queue<Integer> queue = new LinkedList<>();
//         queue.offer(i * cols + j);
//         // 注意：这里要标记上已经访问过
//         visited[i][j] = true;
//         while (!queue.isEmpty()) {
//             int cur = queue.poll();
//             int curX = cur / cols;
//             int curY = cur % cols;
//             for (int k = 0; k < 4; k++) {
//                 int newX = curX + DIRECTIONS[k][0];
//                 int newY = curY + DIRECTIONS[k][1];
//                 if (inArea(newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
//                     queue.offer(newX * cols + newY);
// 特别注意：在放入队列以后，要马上标记成已经访问过，语义也是十分清楚的：反正只要进入了队列，迟早都会遍历到它
// 而不是在出队列的时候再标记，如果是出队列的时候再标记，会造成很多重复的结点进入队列，造成重复的操作，这句话如果你没有写对地方，代码会严重超时
//                     visited[newX][newY] = true;
//                 }
//             }
//         }
//     }

//     private boolean inArea(int x, int y) {
//         return x >= 0 && x < rows && y >= 0 && y < cols;
//     }
// }
class Solution {
    public int numIslands(char[][] grid) {
    int count=0;
    for(int i=0;i<grid.length;i++)
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]=='1'){
                dfsFill(grid,i,j);
                count++;
            }
        }
        return count;
    }
    private void dfsFill(char[][] grid,int i, int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&&grid[i][j]=='1'){
            grid[i][j]='0';
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
        }
    }
}