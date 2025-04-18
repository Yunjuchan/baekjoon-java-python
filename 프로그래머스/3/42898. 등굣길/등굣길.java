class Solution {
    
    static int[] dy = new int[] {1, 0};
    static int[] dx = new int[] {0, 1};
    static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        for (int[] puddle : puddles) {
            int x = puddle[0] - 1;
            int y = puddle[1] - 1;
            dp[y][x] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                for (int k = 0; k < 2; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny >= n || nx >= m || dp[ny][nx] == -1) {
                        continue;
                    }
                    dp[ny][nx] += dp[i][j];
                    dp[ny][nx] %= MOD;
                }
            }
        }
        answer = dp[n - 1][m - 1];
        return answer;
    }
}