import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class c212 {
    public List<String> findWords(char[][] board, String[] words) {

        if (board == null || words == null) return null;

        Trie root = new Trie();

        for (String word: words){
            root.insert(word);
        }

        HashSet<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, ans);
            }
        }
        return new ArrayList<String>(ans);
    }

    private void dfs(char[][] board, int i, int j, Trie root, HashSet<String> ans) {

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        if (!root.children.containsKey(board[i][j])){
            return;
        }
        Trie next = root.children.get(board[i][j]);
        char ch = board[i][j];

        if (!"".equals(next.word)){
            ans.add(next.word);
            next.word = "";
        }
        if (!next.children.isEmpty()){
            board[i][j] = '#';
            for (int[] d: dir){
                int i2 = i + d[0];
                int j2 = j + d[1];
                if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length){
                    dfs(board, i2, j2, next, ans);
                }
            }
            board[i][j] = ch;
        }



        if (next.children.isEmpty()){
            root.children.remove(ch);
        }
    }

    class Trie {
        private HashMap<Character, Trie> children;
        private boolean isEnd;
        private String word;

        public Trie(){
            this.children = new HashMap<>();
            this.isEnd = false;
            this.word = "";
        }

        public void insert(String word){
            char[] chars = word.toCharArray();
            Trie root = this;
            for (int i = 0; i < chars.length; i++){
                if (!root.children.containsKey(chars[i])){
                    root.children.put(chars[i], new Trie());
                }
                root = root.children.get(chars[i]);
            }
            root.isEnd = true;
            root.word = word;
        }

    }
}
