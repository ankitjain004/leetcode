class Solution {
    Map<String, List<String>> adjList = new HashMap<>();
    Set<String> wordList;
    List<List<String>> solution = new ArrayList<>();
    List<String> path = new ArrayList<>();
    
    
    public void backtracking(String currentWord, String endWord)
    {
        if(currentWord.equals(endWord))
        {
            solution.add(new ArrayList(path));
            return;
        }
        List<String> adjacencyList = adjList.getOrDefault(currentWord, new ArrayList<>());
        for(String word : adjacencyList)
        {
            path.add(word);
            backtracking(word, endWord);
            path.remove(path.size()-1);
        }
    }

    public List<String> findNeighbors(String word) {
        char[] currWord = word.toCharArray();
        List<String> neighbors = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            char currentChar = currWord[i];
            for (int j = 0; j < 26; j++) {
                char ch = (char)('a' + j);
                currWord[i] = ch;
                String newWord = new String(currWord);
                if (wordList.contains(newWord)) {
                    neighbors.add(newWord);
                }

            }
            currWord[i] = currentChar;
        }
        
        return neighbors;

    }

    public void bfs(String beginWord) {
        List<String> visited = new ArrayList<>();
        Map<String, Integer> isEnqueued = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        isEnqueued.put(beginWord, 1);
        wordList.remove(beginWord);

        while (!q.isEmpty()) {
            int n = q.size();
            visited = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String curr = q.remove();

                List<String> neighbors = findNeighbors(curr);
                adjList.putIfAbsent(curr, new ArrayList<>());
                for (String neigh : neighbors) {
                    
                    visited.add(neigh);
                    adjList.get(curr).add(neigh);

                    if (!isEnqueued.containsKey(neigh)) {
                        q.add(neigh);
                        isEnqueued.put(neigh, 1);
                    }
                }
            }

            for (String vis : visited) {
                wordList.remove(vis);
            }
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.wordList = new HashSet<>(wordList);
        bfs(beginWord);
        path.add(beginWord);
        backtracking(beginWord, endWord);
        return solution;
    }
}