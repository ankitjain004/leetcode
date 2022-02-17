class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        
        int lcs[][] = new int[n1+1][n2+1];
        
        for(int i=0;i<=n2;i++)
        {
            lcs[0][i] = 0;
        }
        for(int i=0;i<=n1;i++)
        {
            lcs[i][0] = 0;
        }
        
        for(int i=1;i<=n1;i++)
        {
            for(int j=1;j<=n2;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    lcs[i][j] = lcs[i-1][j-1]+1;
                }
                else
                {
                    lcs[i][j] = Integer.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        
        return lcs[n1][n2];
        
    }
}