class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = n-1;
        int i=0;
        int count = n;
        while(i<n&& count>0)
        {
            count--;
            if(nums[i]==0){
            for(int j=i;j<index;j++)
            {
                swap(nums, j,j+1);
            } 
        }
            if(nums[i]!=0)
            i++;
        }
    }
    
    public void swap(int[] nums, int i, int j)
    {
        int temp =nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }
}