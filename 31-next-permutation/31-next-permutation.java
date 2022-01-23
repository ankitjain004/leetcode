class Solution {
    public void nextPermutation(int[] nums) {
           //9 8 7 6 5 4 3 2 1 
        // 1 2 3
        // 1 2 3 5 4 | 1 2 4 3 5
        int n = nums.length;
        int index = n-1;
        for(index=n-1;index>=1;index--)
        {
            if(nums[index-1]<nums[index])
                break;
        }
        index--;
        if(index==-1)
        {
            Arrays.sort(nums);
            return;
        }
        int minIndexGreaterThanIndex = index;
        int maxTillNow = Integer.MAX_VALUE;
        for(int i= index;i<n;i++)
        {
            if(nums[i]>nums[index]&& nums[i]<maxTillNow)
            {
                maxTillNow = nums[i];
                minIndexGreaterThanIndex = i;
            }
        }
        
        swap(nums, index, minIndexGreaterThanIndex);
        
        Arrays.sort(nums, index+1, n);
    }
    
    public void swap(int[] a, int l, int r)
    {
        int temp = a[l];
        a[l]=a[r];
        a[r]= temp;
    }
}