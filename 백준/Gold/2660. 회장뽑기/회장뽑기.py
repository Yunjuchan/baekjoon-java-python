N = int(input())
arr = [[99] * (N+1) for _ in range(N+1)]
score = [0] * (N+1)
for i in range(N+1) :
    arr[i][i] = 0
    arr[i][0] = 0
while True :
    a, b = map(int, input().split())
    arr[a][b] = arr[b][a] = 1
    if a == b == -1 : break
    
for k in range(1, N+1) :
    for i in range(1, N+1) :
        if i == k : continue
        for j in range(1, N+1) :
            if j == k or j == i : continue
            if arr[i][j] > arr[i][k] + arr[k][j] :
                arr[i][j] = arr[i][k] + arr[k][j]
Min = 100
result = []
for i in range(1, N+1) :
    tmp = max(arr[i])
    if Min > tmp :
        Min = tmp
        result = [i]
    elif Min == tmp :
        result.append(i)
print(Min, len(result))
print(*result)