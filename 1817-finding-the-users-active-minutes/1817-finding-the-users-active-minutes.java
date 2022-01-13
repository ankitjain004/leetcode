class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, Set> map = new HashMap<>();
        int[] sol = new int[k];
        Arrays.fill(sol, 0);
        for (int i = 0; i < logs.length; i++) {
            int id = logs[i][0];
            int time = logs[i][1];
            map.putIfAbsent(id, new HashSet<>());
            map.get(id).add(time);
        }

        List<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Set> entry : map.entrySet()) {
            int count = entry.getValue().size();
            sol[count - 1]++;
        }

        return sol;
    }
}