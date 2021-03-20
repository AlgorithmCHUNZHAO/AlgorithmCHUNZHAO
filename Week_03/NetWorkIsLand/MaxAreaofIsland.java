class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int a = area(grid, r, c);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }
    
    int area(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        
        return 1 
            + area(grid, r - 1, c)
            + area(grid, r + 1, c)
            + area(grid, r, c - 1)
            + area(grid, r, c + 1);
    }
    
    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length 
             && 0 <= c && c < grid[0].length;
    }    

}


// public int maxAreaOfIsland(int[][] grid) {
//     int max_area = 0;
//     for(int i = 0; i < grid.length; i++)
//         for(int j = 0; j < grid[0].length; j++)
//             if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
//     return max_area;
// }

// public int AreaOfIsland(int[][] grid, int i, int j){
//     if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
//         grid[i][j] = 0;
//         return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
//     }
//     return 0;
// }