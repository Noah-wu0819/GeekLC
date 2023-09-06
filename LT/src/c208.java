import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class c208 {


    class Trie {

        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String word) {
            char[] words = word.toCharArray();
            Trie node = this;
            for (int i = 0; i < words.length; i++){
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    Trie trie = new Trie();
                    node.children[index] = trie;
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = SearchLast(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = SearchLast(prefix);
            return node != null;
        }

        private Trie SearchLast(String word) {
            Trie root = this;

            for (int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';
                if (root.children[index] == null){
                    return null;
                }
                root = root.children[index];
            }
            return root;
        }
    }


}
