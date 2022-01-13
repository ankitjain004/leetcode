class TopVotedCandidate {
    Map<Integer, Integer> map = new TreeMap<>();
    TreeMap<Integer, Integer> timeVsWinnerMap = new TreeMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        int maxVotes = 0;
        int n = persons.length;
        int winner = -1;

        for (int i = 0; i < n; i++) {
            int person = persons[i];
            int time = times[i];
            int count = map.getOrDefault(person, 0);
            if (count + 1 >= maxVotes) {
                winner = person;
                maxVotes = count + 1;
                timeVsWinnerMap.put(time, winner);
            }

            map.put(person, count + 1);
        }
    }

    public int q(int t) {
        int key = timeVsWinnerMap.floorKey(t);
        return timeVsWinnerMap.get(key);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */