from heapq import heappush, heappop
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N = int(input().rstrip())
visited = [False] * 10001
que = []
result = 0

for _ in range(N) :
    p, d = map(int, input().split())
    heappush(que, (-p, d))

while que :
    p, d = heappop(que)
    for i in range(d, 0, -1) :
        if not visited[i] :
            visited[i] = True
            result -= p
            break

print(result)