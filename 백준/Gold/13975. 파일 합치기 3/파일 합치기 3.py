from heapq import heappush, heappop, heapify
T = int(input())
for _ in range(T) :
    K = int(input())
    que = list(map(int, input().split()))
    heapify(que)
    result = 0
    while len(que) > 1 :
        a, b = heappop(que), heappop(que)
        result += a+b
        heappush(que, a+b)
    print(result)