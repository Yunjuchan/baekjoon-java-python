class Solution {
    
    static long MOD = 1_000_000_007;
    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[n + 1];
        
        dp[0] = 1;
        if (n >= 2) {
            dp[2] = 3;
        } 
        
        for (int i = 4; i <= n; i++) {
            if (i % 2 == 1) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 2] * 4 - dp[i - 4] + MOD;
                dp[i] %= MOD;
            }
        }
        answer = (int) dp[n];
        System.out.println(answer);
        return answer;
    }
}