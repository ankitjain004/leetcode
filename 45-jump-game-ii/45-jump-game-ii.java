class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currentJumpEnd = 0;
        int jumps = 0;
        int maxReached = 0;
        for(int i=0;i<n-1;i++)
        {
            maxReached = Math.max(maxReached, i+nums[i]);
            //if(maxReached>=n-1)break;
            
            if(i==currentJumpEnd)
            {
                currentJumpEnd = maxReached;
                jumps++;
            }
        }
        
        return jumps;
    }
}