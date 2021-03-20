/*
二叉树
void traverse(TreeNode root) {
    
    if(root == null) {
        return
    }
    traverse(root.left);
    traverse(root.right);
}

void dfs(int[][] grid,int r,int c) {
    
    
    if(!inArea(grid,r,c)) {
        return;
    }
    dfs(grid,r - 1,c);
    dfs(grid,r + 1,c);
    dfs(grid,r,c - 1);
    dfs(grid,r,c + 1);
}
boolean inArea(int[][] grid,int r,int c) {
    return 0 <= r && r < grid.length
        && 0 <=c && c < grid[0].length;
}

void dfs(int[][] grid,int r,int c) {
    // 判断base case
    if(!inArea(grid,r,c)) {
        return;
    }
    // 如果这个格子不是岛屿，直接返回
    if (grid[r][c] !=1) {
        return;
    }

    grid[r][c] = 2;// 将格子标记为已遍历过

    dfs(grid,r - 1,c);
    dfs(grid,r + 1,c);
    dfs(grid,r,c - 1);
    dfs(grid,r,c + 1);
}

boolean inArea(int[][] grid,int r,int c) {
    return 0 <= r && r < grid.length
        && 0 <=c && c < grid[0].length;
}

*/



















