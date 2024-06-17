import sys
from heapq import heappop, heappush
input = sys.stdin.readline

N, t, r, c = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(N)]

dist = [[[21e8 for i in range(N)] for j in range(N)] for _ in range(2)]
direct_y = [1,0,-1,0]
direct_x = [0,1,0,-1]

warp = {}
for y in range(N) :
    for x in range(N) :
        nearW = [(-1, -1)] * 4
        for i in range(4) :
            for j in range(1, N) :
                dy = y + direct_y[i]*j
                dx = x + direct_x[i]*j
                if dy<0 or dx<0 or dy>=N or dx>=N : break
                if arr[dy][dx] == "#" :
                    nearW[i] = (dy, dx)
                    break
        warp[(y, x)] = nearW
dist[0][0][0] = 0
q = [(0, 0, 0, 0)]

while q :
    d, isT, y, x = heappop(q)
    if isT and dist[0][y][x] > d : dist[0][y][x] = d
    
    if not isT :
        if dist[1][y][x] > d+t :
            dist[1][y][x] = d+t
            heappush(q, (d+t, 1, y, x))

    for i in range(4) :
        dy = direct_y[i] + y
        dx = direct_x[i] + x
        if dy<0 or dx<0 or dy>=N or dx>= N : continue
        if dist[0][dy][dx] > d+1 :
            dist[0][dy][dx] = d+1
            heappush(q, (d+1, 0, dy, dx))

    if isT :
        for ty, tx in warp[(y, x)] :
            if (ty, tx) == (-1, -1) : continue
            if dist[1][ty][tx] > d+1 :
                dist[1][ty][tx] = d+1
                heappush(q, (d+1, 1, ty, tx))

print(dist[0][r-1][c-1])