class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int maxCount = 0;
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();

        for (int i = 0; i <= n - minSize; i++) {
            String curr = s.substring(i, i + minSize);
            if (eligible(curr, maxLetters)) {
                map.putIfAbsent(curr, 0);
                int newCount = map.get(curr) + 1;
                maxCount = Integer.max(newCount, maxCount);
                map.put(curr, newCount);
            }

        }

        return maxCount;

    }

    private boolean eligible(String s, int maxLetters) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        return set.size() <= maxLetters;
    }
}