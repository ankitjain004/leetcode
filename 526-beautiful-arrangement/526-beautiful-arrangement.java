class Solution {
    int count = 0;
    int N;

    public int countArrangement(int n) {
        N = n;
        boolean visited[] = new boolean[n + 1];
        int currCount = 0;

        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            countUtils(2, visited);
        }

        return count;

    }


    public void countUtils(int index, boolean[] visited) {
        if (index == N + 1) {
            count = count + 1;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (index % i == 0 || i % index == 0)) {
                visited[i] = true;
                countUtils(index + 1, visited);
                visited[i] = false;
            }
        }
    }
}