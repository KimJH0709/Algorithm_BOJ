class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        
        dp[1][1] = 1;
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (i == 1 && j == 1) continue;
                
                if (inWater(i, j, puddles))
                    dp[i][j] = 0;
                else
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        
        return dp[n][m];
    }
    
    public boolean inWater (int i, int j, int[][] puddles) {
        for (int[] pd : puddles) {
            if (pd[0] == j && pd[1] == i)
                return true;
        }
        return false;
    }
}