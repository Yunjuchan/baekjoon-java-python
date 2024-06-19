N = int(input())
dp = [[0] * max(N+1, 3) for _ in range(2)]
dp[1][1] = 1
dp[0][2] = 1
for i in range(3,N+1) :
    dp[0][i] = dp[0][i-1] + dp[1][i-1]
    dp[1][i] = dp[0][i-1]
print(dp[0][N]+dp[1][N])