class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        int count = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            count++;
            for (int k = 0; k < n; k++) {
                String currWord = q.remove();
                char[] word = currWord.toCharArray();

                for (int i = 0; i < currWord.length(); i++) {
                    char ch = word[i];
                    for (int j = 0; j < 26; j++) {
                        word[i] = (char) ('a' + j);
                        String newWord = new String(word);
                        if (wordSet.contains(newWord)) {
                            if (newWord.equals(endWord))
                            {
                                return count+1;
                            }
                            q.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    word[i] = ch;
                }
            }
        }
        return 0;
    }
}