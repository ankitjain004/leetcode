import java.util.*;

class Solution {
    public int minDeletions(String s) {
        int ans = 0;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            freq[index]++;
        }

        Arrays.sort(freq);
        int start = 0;
        int end = 25;
        while (start < end) {
            int temp = freq[start];
            freq[start] = freq[end];
            freq[end] = temp;
            start++;
            end--;
        }

        int maxVal = freq[0];

        Map<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < 26; i++) {
            treeMap.put(freq[i], treeMap.getOrDefault(freq[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = freq[0]; i >= 1; i--) {
            if (treeMap.containsKey(i)) {
                int n = treeMap.get(i); // how many element have frequency i
                if (n > 1) {
                    while (n > 1) {
                        pq.add(i);
                        n--;
                    }
                }
            } else {
                if (!pq.isEmpty()) {
                    int currFreq = pq.poll();
                    ans = ans + currFreq - i;
                }
            }
        }


        while (!pq.isEmpty())
            ans = ans + pq.poll();

        return ans;
    }


}
