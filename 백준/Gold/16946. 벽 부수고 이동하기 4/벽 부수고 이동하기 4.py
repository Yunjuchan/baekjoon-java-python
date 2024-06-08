from collections import deque
import sys
input = sys.stdin.readline
N, M = map(int, input().split())
arr = [list(map(int, list(input().rstrip()))) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
direct_y = [1,0,-1,0]
direct_x = [0,1,0,-1]
dic = {}
dic[1] = 0

def bfs(y, x, tp) :
    que = deque()
    que.append((y, x))
    cnt = 0
    visited[y][x] = True
    arr[y][x] = tp
    while que :
        cnt += 1
        y, x = que.popleft()
        for i in range(4) :
            dy = direct_y[i] + y
            dx = direct_x[i] + x
            if dy<0 or dx<0 or dy>=N or dx>=M or visited[dy][dx] or arr[dy][dx] == 1 : continue
            visited[dy][dx] = True
            arr[dy][dx] = tp
            que.append((dy, dx))
    dic[tp] = cnt
    
tp = 2
for i in range(N) :
    for j in range(M) :
        if arr[i][j] == 1 or visited[i][j] : continue
        bfs(i, j, tp)
        tp += 1

result = [[0] * M for _ in range(N)]

for y in range(N) :
    for x in range(M) :
        if arr[y][x] != 1 : continue
        s = set()
        for i in range(4) :
            dy = direct_y[i] + y
            dx = direct_x[i] + x
            if dy<0 or dx<0 or dy>=N or dx>=M or arr[dy][dx] == 1 : continue
            s.add(arr[dy][dx])
        tmp = 1
        for i in s :
            tmp += dic[i]
        result[y][x] = tmp % 10
        
for r in result :
    print(*r, sep="")