class Solution {
   public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(Comparator.comparingDouble(a -> Math.sqrt(a[0] * a[0] + a[1] * a[1])));

        for (int i = 0; i < points.length; i++) {
            pQueue.add(points[i]);
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pQueue.poll();
        }
        return res;
    }
}