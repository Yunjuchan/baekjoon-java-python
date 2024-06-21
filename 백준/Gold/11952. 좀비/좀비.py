from heapq import heappush, heappop
import sys
input = sys.stdin.readline
N, M, K, S = map(int, input().split())
adj = [[] for _ in range(N+1)]
isZombie = [21e8] * (N+1)
visited = [False] * (N+1)
p, q = map(int, input().split())
zq = []

for _ in range(K) :
    z = int(input())
    heappush(zq, (0, z))
    isZombie[z] = 0

for _ in range(M) :
    s, e = map(int, input().split())
    adj[s].append(e)
    adj[e].append(s)

# 좀비와 어느정도 인접해 있는지
while zq :
    n, now = heappop(zq)
    if isZombie[now] < n : continue
    for next in adj[now] :
        if isZombie[next] <= n+1 : continue
        isZombie[next] = n+1
        heappush(zq, (n+1, next))

# 실제 이동
pq = [(0, 1)]
visited[1] = True
while pq :
    w, now = heappop(pq)
    if now == N : break
    for next in adj[now] :
        if visited[next] or isZombie[next] == 0 : continue
        visited[next] = True
        if next == N : 
            heappush(pq, (w, next))
            break
        if isZombie[next] > S :
            heappush(pq, (w+p, next))
        else :
            heappush(pq, (w+q, next))

print(w)