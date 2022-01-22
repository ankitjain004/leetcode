class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] hold=new int[n];
        int[] nohold=new int[n];
        int[] cooldown = new int[n];
        
        hold[0]=-prices[0];
        nohold[0]=0;
        cooldown[0]=0;
        
        for(int i=1;i<n;i++)
        {
            hold[i] = Integer.max(hold[i-1],cooldown[i-1]-prices[i]);;
            nohold[i] = Integer.max(nohold[i-1],hold[i-1]+prices[i]);
            cooldown[i] = Integer.max(cooldown[i-1],nohold[i-1]);
        }
        
        return Integer.max(cooldown[n-1],nohold[n-1]);
        
        
    }
}