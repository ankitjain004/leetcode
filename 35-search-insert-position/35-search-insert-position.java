class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n-1;
        int ans = -1;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid]==target) return mid;
            
            else if (nums[mid]<target)
            {
                ans = mid;
                lo = mid+1;
            }
            else if(nums[mid]>target)
            {
                hi = mid -1;
            }
        }
        
        return ans+1;
    }
}