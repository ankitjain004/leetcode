class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int inclusive = nums[0];
        int exclusive = 0;
        
        for(int i=1;i<n;i++)
        {
            int pre_exclusive = exclusive;
            exclusive = Math.max(inclusive, exclusive);
            inclusive = Math.max(inclusive, pre_exclusive+nums[i]);
        }
        
        
        return Math.max(inclusive, exclusive);
    }
}