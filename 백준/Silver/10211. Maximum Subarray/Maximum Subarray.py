T = int(input())

def dfs(start, level, path) :
    global result
    if level == 2 :
        if result < arr[path[1]] - arr[path[0]] :
            result = arr[path[1]] - arr[path[0]]
        return
    for i in range(start, N+1) :
        dfs(i+1, level+1, path+[i])

for _ in range(T) :
    N = int(input())
    arr = [0] + list(map(int, input().split()))
    for i in range(N) :
        arr[i+1] += arr[i]
    result = -21e8
    dfs(0, 0 , [])
    print(result)