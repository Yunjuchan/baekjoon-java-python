import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int l = info.length;
        int[][] dp = new int[l][m];
        for (int i = 0; i < l; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][0] = info[0][0];
        if (info[0][1] < m) {
            dp[0][info[0][1]] = 0;
        }
        
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i - 1][j] != Integer.MAX_VALUE) {
                    // A가 훔치는 경우
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + info[i][0]);
                    // B가 훔치는 경우
                    if (j + info[i][1] < m) {
                        dp[i][j + info[i][1]] = Math.min(dp[i][j + info[i][1]], dp[i - 1][j]);
                    }
                }
            }
        }
        
        answer = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            answer = Math.min(answer, dp[l - 1][j]);
        }
        
        if (answer >= n) {
            answer = -1;
        }
        
        return answer;
    }
}