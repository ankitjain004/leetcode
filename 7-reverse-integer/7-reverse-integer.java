class Solution {
    public int reverse(int x) {
        int number = 0;
        while(x!=0)
        {
            int rem = x%10;
            
            //Integer.MIN_VALUE = -2147483648
            //Integer.MAX_VALUE = 2147483647
            if(number>Integer.MAX_VALUE/10 || (number == Integer.MAX_VALUE/10 && rem >7)) return 0;
            if(number<Integer.MIN_VALUE/10 || (number == Integer.MIN_VALUE/10 && rem <-8)) return 0;
            number = number*10 + rem;
            x = x/10;
        }
        
        return number;
    }
}