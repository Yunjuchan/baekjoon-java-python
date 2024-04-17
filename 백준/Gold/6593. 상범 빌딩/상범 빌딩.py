import sys
from collections import deque
input = sys.stdin.readline

direct_y = [1,0,-1,0,0,0]
direct_x = [0,1,0,-1,0,0]
direct_z = [0,0,0,0,1,-1]
def bfs(start, end) :
    que = deque()
    que.append((0, *start))
    z, y, x = start
    visited[z][y][x] = True
    while que :
        cnt, z, y, x = que.popleft()
        if (z, y, x) == end :
            return cnt
        for i in range(6) :
            dz = z + direct_z[i]
            dy = y + direct_y[i]
            dx = x + direct_x[i]
            if dz < 0 or dy < 0 or dx < 0 or dz >= L or dy >= R or dx >= C or arr[dz][dy][dx] == '#' or visited[dz][dy][dx] : continue
            que.append((cnt+1, dz, dy, dx))
            visited[dz][dy][dx] = True
    return -1


while True :
    
    L, R, C = map(int, input().split())
    if L == R == C == 0 : break
    
    arr = []
    visited = [[[False] * C for _ in range(R)] for _ in range(L)]
    
    for i in range(L) :
        floor = []
        for j in range(R) :
            tmp = list(input().rstrip())
            for k in range(C) :
                if tmp[k] == 'S' :
                    start = (i, j, k)
                elif tmp[k] == 'E' :
                    end = (i, j, k)
            floor.append(tmp)
        input()
        arr.append(floor)
    result = bfs(start, end)
    if result == -1:
        print("Trapped!")
    else :
        print(f"Escaped in {result} minute(s).")