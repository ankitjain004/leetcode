class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0 ;
        map.putIfAbsent(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                count--;
            }
            else if(nums[i]==1)
            {
                count++;
            }
            if(map.containsKey(count))
            {
                int currLen = i-map.get(count);
                if(currLen>maxLen)
                {
                    maxLen=currLen;
                }
            }
            else
            {
                map.putIfAbsent(count, i);
            }
        }
        
        return maxLen;
        
    }
}