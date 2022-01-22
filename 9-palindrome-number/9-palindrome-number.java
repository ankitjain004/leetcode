class Solution {
    public boolean isPalindrome(int x) {
        Stack<Integer> stk = new Stack<>();
        int temp = x;
        boolean isNegative = false;
        if(x<0) x = -1*x;
        while(temp!=0)
        {
            stk.push(temp%10);
            temp/=10;
        }
        
        temp = x;
        while(temp!=0)
        {
            int rem = temp%10;
            if(stk.pop()!=rem) return false;
            temp /=10;
        }
        return true;
    }
}