N = int(input())
dp = [[0] * 10 for _ in range(N+1)] 
for i in range(1,10) :
    dp[1] = [0,1,1,1,1,1,1,1,1,1]
for i in range(2, N+1) :
    for j in range(1, 10) :
        for k in range(max(j-2, 0), min(j+3, 10)) :
            dp[i][j] += dp[i-1][k]
        dp[i][j] %= 987654321
print(sum(dp[N]) % 987654321)