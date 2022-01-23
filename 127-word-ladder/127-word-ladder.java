/*
1. take a word
2. make all possible combinations from tht word by replacing each letter of word one by one with all 26 letters
4. Check if they are present in set . If yes put them in queue and proceed . Remove the element from set so as not to get stuck in infinite loop
5. If you encounter endWord you got it


*/
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