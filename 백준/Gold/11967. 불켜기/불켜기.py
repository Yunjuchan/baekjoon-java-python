import sys
input = sys.stdin.readline
from collections import deque
N, M = map(int, input().split())
dic = {}
possible = set()
visited = [[False] * (N+1) for _ in range(N+1)]
light = [[False] * (N+1) for _ in range(N+1)]
direct_y = [1,0,-1,0]
direct_x = [0,1,0,-1]
que = deque()
que.append((1, 1))
possible.add((1, 1))
light[1][1] = True

for _ in range(M) :
    x,y,a,b = map(int, input().split())
    dic[(x, y)] = dic.get((x, y), []) + [(a, b)]

while que :
    x, y = que.popleft()
    visited[x][y] = True
    for i in range(4) :
        dy = direct_y[i] + y
        dx = direct_x[i] + x
        if dy<=0 or dx<=0 or dy>=(N+1) or dx>=(N+1) or (dx, dy) in possible: continue
        if light[dx][dy] and not visited[dx][dy] :
            que.append((dx, dy))
        possible.add((dx, dy))
    
    for nx, ny in dic.get((x, y), []) :
        if visited[nx][ny] : continue
        light[nx][ny] = True
        if (nx, ny) in possible :
            que.append((nx, ny))

cnt = 0
for i in range(N+1) :
    for j in range(N+1) :
        if light[i][j] : cnt += 1
print(cnt)