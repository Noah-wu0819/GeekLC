import java.util.ArrayList;
import java.util.List;

public class c54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length < 1 || matrix == null || matrix[0].length < 1) return  null;
        List<Integer> ans = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int count = row * col;

        int top = 0;
        int left = 0;

        int right = col - 1;
        int bottom = row - 1;
        while (ans.size() != count){
            for (int i = left; i <= right; i++){
                ans.add(matrix[top][i]);
            }

            for (int j = top + 1; j <= bottom; j++){
                ans.add(matrix[j][right]);
            }

            if (left < right && top < bottom){
                for (int i = right - 1; i >= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                for (int j = bottom - 1; j > top; j--){
                    ans.add(matrix[j][left]);
                }
            }
            top++;bottom--;left++;right--;
        }
        return ans;
    }
}
