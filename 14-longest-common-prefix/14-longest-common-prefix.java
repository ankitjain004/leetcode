class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        for(int i=1;i<strs.length;i++)
        {
            str = lcp(strs[i],str);
        }
        return str;
        
    }
    
    public String lcp(String str1, String str2)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Integer.min(str1.length(), str2.length()); i++)
        {
            if(str1.charAt(i)==str2.charAt(i))
            {
                sb.append(str1.charAt(i));
            }
            else
            {
                break;
            }
        }
        
        return sb.toString();
    }
}