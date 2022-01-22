class Solution {
    public int reverse(int x) {
        int number = 0;
        boolean isNegative = false;
        if(x<0) isNegative = true;
        x = Math.abs(x);
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
        if(isNegative) number = -1*number;
        return number;
    }
}