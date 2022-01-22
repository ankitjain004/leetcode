class Solution {
    public int myAtoi(String s) {
        int number = 0;
        int n = s.length();
        if(n==0) return 0;
        int i=0;
        boolean isNegative = false;
        while(i<n && s.charAt(i)!=' ' && s.charAt(i)!='+' && s.charAt(i)!='-' && !Character.isDigit(s.charAt(i)))
        {
            return 0;
        }
        while(i<n && s.charAt(i)==' ')
        {
            i++;
        }
        if(i<n && s.charAt(i)=='-')
        {
            isNegative = true;
        }
        if(i<n && (s.charAt(i)=='-'|| s.charAt(i)=='+'))i++;

        while(i<n)
        {
            int curr = s.charAt(i)-'0';
            if(curr<0 || curr>9) break;
            if( (number>Integer.MAX_VALUE/10) || (number==Integer.MAX_VALUE/10 && curr >Integer.MAX_VALUE%10 )) 
                return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            
            number = (number*10)+curr;
            
            i++;
        }
        if(isNegative) number = -1*number;        
        return number;
    }
}