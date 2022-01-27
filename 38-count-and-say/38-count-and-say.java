class Solution {
    int N;
    public String countAndSay(int n) {
        this.N = n;
        if(n==1) return "1";
        if(n==2) return "11";
        return countAndSayUtils("11", 2);
    }
    
    
    public String countAndSayUtils(String s, int counter)
    {
        if(counter==N) return s;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i=1;
        int count = 1;
        Character ch = s.charAt(0);
        while(i<n)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                count++;
            }
            else
            {
                sb.append(Integer.toString(count));
                sb.append(s.charAt(i-1));
                count =1 ;
                ch = s.charAt(i);
            }
            
            if(i==n-1)
            {
                sb.append(Integer.toString(count));
                sb.append(s.charAt(i));
            }
            i++;
        }
        return countAndSayUtils(sb.toString(), counter+1);
    }
}