N= int(input())
arr = list(map(int, input().split()))
M = [[(-1,-1)] * N for _ in range(N)]
dp = [0] * N
Min = 10001
Max = -1
for i in range(N) :
    Min = Max = arr[i]
    for j in range(i, N) :
        if Min > arr[j] :
            Min = arr[j]
        if Max < arr[j] :
            Max = arr[j]
        M[i][j] = (-Min, Max)

for i in range(1, N):
    for k in range(i) :
        dp[i] = max(dp[i], dp[k-1] + sum(M[k][i]))
print(dp[-1])