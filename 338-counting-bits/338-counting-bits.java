class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int j=0;j<=n;j++)
        {
            
            String str = Integer.toBinaryString(j);
            int cnt = 0;
            int i=0;
            for(i = 0;i<str.length();i++)
            {
                if(str.charAt(i)=='1')
                {
                    cnt++;
                }
            }
            ans[j] = cnt;
            
        }
        
        return ans;
    }
}