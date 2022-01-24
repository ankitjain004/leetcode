class Solution {
    Set<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        int n = s.length();
        Boolean[] dp = new Boolean[n];
        return wordBreakUtils(s,0, dp);
    }

    public boolean wordBreakUtils(String s, int index, Boolean[] dp)
    {
        int n = s.length();
        if(n==index) return true;
        if(dp[index]!=null) return dp[index];
        for(int i= index+1;i<=n;i++)
        {
            if(set.contains(s.substring(index, i)) && wordBreakUtils(s, i, dp))
                return dp[index] = true;
        }
        
        return dp[index] = false;
    }
}