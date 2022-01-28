class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean word = false;

    public TrieNode() {
    }
}


class WordDictionary {
    TrieNode node;

    public WordDictionary() {
        node = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode temp = node;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (temp.children.containsKey(ch)) {
                temp = temp.children.get(ch);
            } else {
                temp.children.put(ch, new TrieNode());
                temp = temp.children.get(ch);
            }
        }

        temp.word = true;
    }

    public boolean search(String word) {
        TrieNode temp = node;
        return searchUtils(word, temp);
    }

    public boolean searchUtils(String word, TrieNode temp) {
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (temp.children.containsKey(ch)) {
                temp = temp.children.get(ch);
            } else if (ch == '.') {
                for (char curr : temp.children.keySet()) {
                    TrieNode child = temp.children.get(curr);
                    if (searchUtils(word.substring(i + 1), child))
                        return true;
                }

                return false;

            } else
                return false;
        }
        return temp.word;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */