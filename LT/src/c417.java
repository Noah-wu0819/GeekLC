import java.util.ArrayList;
import java.util.List;

public class c417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        if (heights.length < 1 || heights == null){
            return null;
        }

        List<List<Integer>> ans = new ArrayList<>();
        int col = heights[0].length;
        int row = heights.length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        //第一行和第一列的 pacific
        for (int i = 0; i < col; i++){
            dfs(heights,0, i, pacific);
        }
        for (int i = 0; i < row; i++){
            dfs(heights, i, 0, pacific);
        }
        //最后一行和最后一列的atlantic
        for (int i = 0; i < col; i++){
            dfs(heights,row-1, i, atlantic);
        }
        for (int i = 0; i < row; i++){
            dfs(heights, i, col-1, atlantic);
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    List<Integer> set = new ArrayList<>();
                    set.add(i);
                    set.add(j);
                    ans.add(set);
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] heights, int row, int col, boolean[][] ocean){
        if (ocean[row][col] == true){
            return;
        }
        ocean[row][col] = true;
        //上下左右探索
        if ((row - 1) >= 0 && heights[row - 1][col] >= heights[row][col]){
            dfs(heights, row-1, col, ocean);
        }

        if ((row + 1) < heights.length && heights[row + 1][col] >= heights[row][col]){
            dfs(heights, row + 1, col, ocean);
        }

        if ((col - 1) >= 0 && heights[row][col - 1] >= heights[row][col]){
            dfs(heights, row, col - 1, ocean);
        }

        if ((col + 1) < heights[0].length && heights[row][col + 1] >= heights[row][col]){
            dfs(heights, row, col + 1, ocean);
        }
    }
}
