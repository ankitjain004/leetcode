class Solution {
      public int maxProfit(int[] prices) {
       int n = prices.length;
       int minPrice = Integer.MAX_VALUE;
       int profit = 0;
          
        for(int i=0;i<n;i++)
        {
            if(prices[i]<minPrice)
            {
                minPrice = prices[i];
            }
            if(prices[i]-minPrice>profit)
            {
                profit = prices[i]-minPrice;
            }
        }
        return profit;        
}
    
//     public int maxProfit(int[] prices) {
//         //7,1,5,3,6,4
//         int n = prices.length;
//         int[] minPriceFromLeft = new int[n];
//         int[] maxPriceFromRight = new int[n];
//         // for first element
//         minPriceFromLeft[0]=prices[0];
//         for(int i=1;i<n;i++)
//         {
//             minPriceFromLeft[i] = Integer.min(minPriceFromLeft[i-1], prices[i]);
//         }
//         //for last element max profit will be only that element
//         maxPriceFromRight[n-1]=prices[n-1];
//         for(int i=n-2;i>=0;i--)
//         {
//             maxPriceFromRight[i] = Integer.max(maxPriceFromRight[i+1], prices[i]);
//         }
        
//         int profit = 0;
        
//         for(int i=0;i<n;i++)
//         {
//             int curr_profit = maxPriceFromRight[i] - minPriceFromLeft[i];
//             profit = Integer.max(curr_profit, profit);
//         }
        
//         return profit;
//     }
}