N = int(input())
vip = [False] * (N+1)
dp = [0] * (N+1)
dp[0] = dp[1] = 1
M = int(input())
for _ in range(M) :
    x = int(input())
    vip[x] = True


for i in range(2, N+1) :
    if vip[i] or vip[i-1] :
        dp[i] = dp[i-1]
    else :
        dp[i] = dp[i-2] + dp[i-1]
print(dp[N])