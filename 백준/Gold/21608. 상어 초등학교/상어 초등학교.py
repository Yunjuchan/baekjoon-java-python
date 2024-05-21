from heapq import heappop, heappush
N = int(input())
favorite = [[] for _ in range(N*N+1)]
seat = [[0] * N for _ in range(N)]
direct_y = [1,0,-1,0]
direct_x = [0,1,0,-1]
score = [0,1,10,100,1000]
for _ in range(N*N) :
    idx, *arr = map(int, input().split())
    favorite[idx] = set(arr)
    que = []
    for i in range(N) :
        for j in range(N) :
            if seat[i][j] != 0 : continue
            Max = 0
            like = 0
            empty = 0
            for k in range(4) :
                dy = i + direct_y[k]
                dx = j + direct_x[k]
                if dy<0 or dx<0 or dy>=N or dx>=N : continue
                if seat[dy][dx] == 0 : empty += 1
                elif seat[dy][dx] in favorite[idx] : like += 1
        
            if like >= Max :
                Max = like
                heappush(que, (-like, -empty, i, j))
    like, empty, y, x = heappop(que)
    seat[y][x] = idx

result = 0

for y in range(N) :
    for x in range(N) :
        cnt = 0
        for i in range(4) :
            idx = seat[y][x]
            dy = y + direct_y[i]
            dx = x + direct_x[i]
            if dy<0 or dx<0 or dy>=N or dx>=N : continue
            if seat[dy][dx] in favorite[idx] :
                cnt += 1
        result += score[cnt]
print(result)