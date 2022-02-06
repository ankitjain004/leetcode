class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        int i=1;
        int lastElement = nums[0];
        int count = 1;
        int sortedTill = 0;
        while(i<n)
        {
            if(nums[i]==lastElement&& count ==1)
            {
                count++;
                nums[++sortedTill] = nums[i];
                i++;
            }
            else if(nums[i]==lastElement && count >= 2)
            {
                count++;
                i++;
            }
            else if(nums[i]!=lastElement)
            {
                count = 1;
                lastElement = nums[i];
                nums[++sortedTill] = nums[i];
                i++;
            }                
        }
        
        return sortedTill+1;
        
    }
}