import sys
from collections import deque
input = sys.stdin.readline

direct_y = [2,2,-2,-2,1,1,-1,-1]
direct_x = [1,-1,1,-1,2,-2,2,-2]

T = int(input())
for _ in range(T) :
    N = int(input())
    visited = [[False] * N for _ in range(N)]
    start_y, start_x = map(int, input().split())
    visited[start_y][start_x] = True
    end_y, end_x = map(int, input().split())
    que = deque()
    que.append((0, start_y, start_x))
    while que :
        cnt, y, x = que.popleft()
        if y == end_y and x == end_x :
            print(cnt)
            break
        for i in range(8) :
            dy = direct_y[i] + y
            dx = direct_x[i] + x
            if dy < 0 or dx < 0 or dy >= N or dx >= N or visited[dy][dx] : continue
            visited[dy][dx] = True
            que.append((cnt+1, dy, dx))