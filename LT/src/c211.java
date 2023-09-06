public class c211 {
    class WordDictionary {
        private WordDictionary[] children;
        private boolean isEnd;

        public WordDictionary() {
            this.children = new WordDictionary[26];
            this.isEnd = false;
        }


        public void addWord(String word) {
            char[] words = word.toCharArray();
            WordDictionary node = this;
            for (int i = 0; i < words.length; i++){
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    WordDictionary wordDictionary = new WordDictionary();
                    node.children[index] = wordDictionary;
                }

                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            WordDictionary root = this;

            return dfs(word, 0, root);
        }



        private boolean dfs(String word, int index, WordDictionary node){
            if (index == word.length()) {
                return node.isEnd;
            }

            char ch = word.charAt(index);
            if (ch == '.'){
                for (int i = 0; i < 26; i++){
                    WordDictionary child = node.children[i];
                    if (child!=null && dfs(word,index + 1,child))
                        return true;
                }
            }else {
                int next = ch - 'a';
                WordDictionary child = node.children[next];
                if (child != null && dfs(word, index + 1, child)){
                    return true;
                }
            }
            return false;
        }
    }
}
