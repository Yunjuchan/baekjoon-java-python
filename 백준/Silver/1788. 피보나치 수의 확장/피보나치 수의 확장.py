N = int(input())

isplus = 1
if N < 0 and N % 2 == 0 :
    isplus = -1
elif N == 0 :
    isplus = 0
N = abs(N)
dp = [0] * (1000001)
dp[1] = 1

for i in range(2, N+1) :
    dp[i] = (dp[i-1] + dp[i-2]) % 10**9

print(isplus)
print(dp[N])