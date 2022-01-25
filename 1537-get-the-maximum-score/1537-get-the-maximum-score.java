class Solution {
    int mod = 1000000007;
    public int maxSum(int[] nums1, int[] nums2) {
        long currSum = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        long sum1 =0;
        long sum2 = 0;
        int i=0;
        int j=0;
        
        while(i<n1 && j<n2)
        {
            if(nums1[i]==nums2[j])
            {
                currSum += Math.max(sum1, sum2)+ nums1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])
            {
                sum1 = sum1 + nums1[i++];
            }
            else
            {
                sum2 = sum2 + nums2[j++];
            }
        }
        
        while(i<n1)
        {
            sum1+= nums1[i++];
        }
        
        while(j<n2)
        {
            sum2+= nums2[j++];
        }
        
        
        return (int)((Math.max(sum1, sum2) + currSum)%mod);
    }
}