public class c200 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int row, int col){
        if (grid[row][col] == '0') return;
        grid[row][col] = '0';

        if ( row - 1 >= 0){
            dfs(grid, row - 1, col);
        }

        if ( row + 1 < grid.length){
            dfs(grid, row + 1, col);
        }

        if ( col - 1 >= 0){
            dfs(grid, row, col - 1);
        }

        if ( col + 1 < grid[0].length){
            dfs(grid, row, col + 1);
        }
    }
}
