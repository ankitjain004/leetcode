class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int count = 0;
        for(int i=0;i<n;i++)
        {
            sum = sum + nums[i];
            int rem = ((sum%k)+k)%k;
            map.putIfAbsent(rem, 0);
            map.put(rem, map.get(rem)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int key = entry.getKey();
            int val = entry.getValue();
            if(key == 0)  
            {
                val = val+1;
            }
            count = count + ((val)*(val-1))/2;
        }
        
        return count;
        
    }
}