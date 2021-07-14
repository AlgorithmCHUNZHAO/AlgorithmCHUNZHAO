class Solution {
    int countPaths(boolean[][] grid,int row,int col) {
        if(!validSquare(grid,row,col)) return 0;
        if(!isAtEnd(grid,row,col)) return 1;
        return countPaths(grid,row+1,col) + countPaths(grid,row,col + 1);
    }
}