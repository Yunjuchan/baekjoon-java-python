class Solution {
    
    public static int fibonachi(int x) {
        if (x <= 1) {
            return x;
        }
        return (fibonachi(x - 2) + fibonachi(x - 1)) % 1234567;
    }
    
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}