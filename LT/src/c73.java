public class c73 {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] zero_row = new int[row];
        int[] zero_col = new int[col];

        for (int i = 0; i < row; i++){
            for ( int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    zero_row[i] = 1;
                    zero_col[j] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++){
            for ( int j = 0; j < col; j++){
                if (zero_row[i] == 1 ||zero_col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
