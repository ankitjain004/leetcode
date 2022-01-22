class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int start = 0;
        int end = n - 1;
        int maximumWater = 0;
        while (start < end) {
            int left = height[start];
            int right = height[end];
            maximumWater = Math.max(maximumWater, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maximumWater;
    }
}