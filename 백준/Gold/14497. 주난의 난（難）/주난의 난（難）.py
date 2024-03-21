from heapq import heappop, heappush
N, M = map(int, input().split())
x1, y1, x2, y2 = map(int, input().split())
arr = [list(input()) for _ in range(N)]
direct_x = [1,0,-1,0]
direct_y = [0,1,0,-1]
que = []
heappush(que, (0, x1-1, y1-1))
while que:
    level, x, y = heappop(que)
    # print("now:", level, x, y)
    if x == x2-1 and y == y2-1:
        print(level)
        break
    if arr[x][y] == -1 : continue
    arr[x][y] = -1
    
    for i in range(4):
        dx = direct_x[i] + x
        dy = direct_y[i] + y
        if dx < 0 or dy < 0 or dx >= N or dy >= M : continue
        if arr[dx][dy] == -1 :
            continue
        elif arr[dx][dy] == '0' :
            heappush(que, (level, dx, dy))
        else :
            heappush(que, (level+1, dx, dy))