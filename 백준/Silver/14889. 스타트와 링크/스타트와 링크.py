N = int(input())
total = 0
arr = []
visited = [False] * N
for _ in range(N) :
    lst = list(map(int, input().split()))
    total += sum(lst)
    arr.append(lst)
result = total
# a팀 b팀으로 나눠서 계산
def dfs(level, start, a, b):
    global result
    if result < (a-b): return
    if level == N//2 :
        if result > abs(a-b) :
            result = abs(a-b)
        return
    
    for i in range(start+1, N) :
        if visited[i]: continue
        visited[i] = True
        tmp = tmp2 = 0
        
        for j in range(N) :
            if visited[j] : 
                tmp += arr[i][j] + arr[j][i]
            else :
                tmp2 += arr[i][j] + arr[j][i]
        dfs(level+1, i, a+tmp, b-tmp2)
        visited[i] = False
        
dfs(0, 0, 0, total)
print(result)