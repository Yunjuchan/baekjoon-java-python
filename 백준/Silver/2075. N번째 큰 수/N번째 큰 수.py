from heapq import heappop, heappush

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
pq = []
for i in range(N) :
    heappush(pq, (-arr[N-1][i], N-1, i))
cnt = 0
while True :
    value, loc_y, loc_x = heappop(pq)
    cnt += 1
    if cnt == N :
        print(-value)
        break
    if loc_y == 0 : continue
    heappush(pq, (-arr[loc_y-1][loc_x], loc_y-1, loc_x))