from collections import deque

N, K = map(int, input().split())

direct = [-1,1]
que = deque()
visited = [False] * 100001
que.append((0, N))
visited[N] = True
while que:
    level, now = que.popleft()
    if now == K : break
    for i in range(2):
        next = direct[i] + now
        if next < 0 or next > 100000 : continue
        if visited[next]: continue
        visited[next] = True
        que.append((level+1, next))
    next = now * 2
    if next < 0 or next > 100000 : continue
    if visited[next]: continue
    visited[next] = True
    que.append((level+1, next))
print(level)