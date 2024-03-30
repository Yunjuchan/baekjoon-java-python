def dfs(start, now, level, path):
    global cycle
    if level != 0 and now == start: 
        cycle += path + [arr[now]]
        return
    if visited[now]: return
    visited[now] = True
    dfs(start, arr[now]-1, level+1, path+[i+1])
    
N = int(input())
arr = []
cycle = []
for _ in range(N):
    arr.append(int(input()))

for i in range(N):
    visited = [False] * (N+1)
    dfs(i, i, 0, [])
cycle = sorted(list(set(cycle)))
print(len(cycle))
for i in cycle:
    print(i)