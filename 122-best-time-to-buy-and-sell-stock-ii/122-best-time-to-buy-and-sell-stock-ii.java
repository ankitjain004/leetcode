class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        if(n==0) return 0;
        //1 2 3 4 5
        for(int i=1;i<n;i++)
        {
            if(prices[i-1]<prices[i])
                profit += prices[i]-prices[i-1];
        }
        
        return profit;
    }
}