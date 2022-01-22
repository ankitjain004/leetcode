class Solution {
    HashMap<Integer, Boolean> cache = new HashMap<>();
    public boolean winnerSquareGame(int n) {
        cache.put(0, false);
        return dfs(n);
        
    }
    
    boolean dfs(int n)
    {
        if(cache.containsKey(n))
            return cache.get(n);
        
        int k = (int)Math.sqrt(n);
        for(int i=1;i<=k;i++)
        {
            boolean canMakeNextPlayerLoseWithRemain = !dfs(n-i*i);
            if(canMakeNextPlayerLoseWithRemain)
            {
                cache.put(n, true);
                return true;
            }
        }
        cache.put(n, false);
        return false;
    }
}