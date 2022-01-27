import java.util.Arrays;

class Solution {
    String word1;
    String word2;
    int[][] dp ;

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length()+1;i++)
        {
            for(int j=0;j<word2.length()+1;j++)
            {
                dp[i][j] = -1;
            }
        }
        this.word1 = word1;
        this.word2 = word2;

        return minDistanceUtils(0, 0);

    }

    public int minDistanceUtils(int m, int n) {
        if (m == word1.length() && n == word2.length()) 
            return 0;
        if (m == word1.length())
            return word2.length() - n;
        if (n == word2.length())
            return word1.length() - m;
        if (dp[m][n] != -1) return dp[m][n];
        if (word1.charAt(m) == word2.charAt(n))
            return minDistanceUtils(m + 1, n + 1);

        int insert = minDistanceUtils(m, n + 1) + 1;
        int delete = minDistanceUtils(m + 1, n) + 1;
        int replace = minDistanceUtils(m + 1, n + 1) + 1;
        return dp[m][n] = Math.min(Math.min(insert, delete), replace);
    }
}