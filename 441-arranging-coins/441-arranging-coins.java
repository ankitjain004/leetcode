class Solution {
    public int arrangeCoins(int n) {
        
        int number = 1;
        int sum = n;
        
        while(sum-number>=0)
        {
            sum = sum - number;
            number++;
        }
        return number-1;
        
    }
}