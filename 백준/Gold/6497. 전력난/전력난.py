import sys
from heapq import heappush, heappop

input = sys.stdin.readline

while True:
    m, n = map(int, input().split())
    if m == n == 0 : break
    visited = [False] * (m)
    edge = [[] for _ in range(m)]
    total = 0
    for _ in range(n):
        x, y, z = map(int, input().split())
        edge[y].append((z, x))
        edge[x].append((z, y))
        total += z
        
    w = 0
    que = []
    que.append((0,0))
    while que:
        z, now = heappop(que)
        if visited[now]: continue
        visited[now] = True
        w += z
        for next_z, next in edge[now]:
            if visited[next]: continue
            heappush(que, (next_z, next))
    print(total - w)