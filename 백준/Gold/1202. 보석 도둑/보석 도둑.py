from heapq import heappush, heappop
import sys
input = sys.stdin.readline
N, K = map(int, input().split())
lst = []
for _ in range(N) :
    M, V = map(int, input().split())
    lst.append([M, V])
lst.sort()
bag = []
for _ in range(K) :
    bag.append(int(input()))
bag.sort()
i = j = 0
total = 0
res = []
result = []
while True :
    if i == N or j == K :
        break
    if lst[i][0] <= bag[j] :
        heappush(res, -lst[i][1])
        i += 1
    elif lst[i][0] > bag[j] :
        if res :
            total -= heappop(res)
        j += 1

for i in range(j,K) :
    if not res :
        break
    total -= heappop(res)
print(total)
