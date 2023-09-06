public class c79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1){
            return false;
        }
        int n = board.length;
        int m = board[0].length;
        boolean[][] isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){

                boolean flag = check(i, j, 0, board, word,isVisited);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(int i, int j, int k, char[][] board, String word, boolean[][] isVisited) {
        if (board[i][j] != word.charAt(k)){
            return false;
        }
        if (k == word.length()-1){
            return true;
        }

        isVisited[i][j] = true;
        int[][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean result = false;

        for (int[] dir: direction){
            int newi = i + dir[0];
            int newj = j + dir[1];

            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length && !isVisited[newi][newj]){
                boolean flag = check(newi, newj, k+1, board, word, isVisited);
                if (flag){
                    result = true;
                    break;
                }
            }

        }
        isVisited[i][j] = false;
        return result;
    }

}
