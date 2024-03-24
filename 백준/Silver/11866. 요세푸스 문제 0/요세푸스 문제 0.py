import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
que = deque(i for i in range(1, N+1))
cnt = 0
result = []
for _ in range(N) :
    i = 1
    while True:
        x = que.popleft()
        if i == K :
            result.append(x)
            break
        i += 1
        que.append(x)
print('<', end='')
print(*result, sep=', ', end='>')