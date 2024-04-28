import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
arr = [[],[]]

visited = [[[False] * N for _ in range(N)] for _ in range(2)]
que = deque()

result = [0,0]
for _ in range(N) :
    x = input().rstrip()
    arr[0].append(list(x))
    x = x.replace("R", "G")
    arr[1].append(list(x))

direct_y = [1,0,-1,0]
direct_x = [0,1,0,-1]
def bfs(i, j, k) :
    que.append((i, j))
    while que :
        y, x = que.popleft()
        for i in range(4) :
            dy = direct_y[i] + y
            dx = direct_x[i] + x
            if dy < 0 or dx < 0 or dy >= N or dx >= N or visited[k][dy][dx] or arr[k][dy][dx] != arr[k][y][x]: continue
            visited[k][dy][dx] = True
            que.append((dy, dx))

for i in range(N) :
    for j in range(N) :
        for k in range(2) :
            if visited[k][i][j] : continue
            visited[k][i][j] = True
            result[k] += 1
            bfs(i, j, k)
            
print(*result)