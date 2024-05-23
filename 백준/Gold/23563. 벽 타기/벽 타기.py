import sys
from heapq import heappush, heappop
input = sys.stdin.readline
H, W = map(int, input().split())
arr = [list(input()) for _ in range(H)]
direct_y = [1,0,-1,0]
direct_x = [0,1,0,-1]

for i in range(H) :
    for j in range(W) :
        if arr[i][j] == "#" : continue
        elif arr[i][j] == "S" :
            y1, x1 = i, j
        elif arr[i][j] == "E" :
            y2, x2 = i, j
        
        tmp = False
        for k in range(4) :
            if tmp == True : break
            dy = i + direct_y[k]
            dx = j + direct_x[k]
            if dy<0 or dx<0 or dy>=H or dx>=W : continue
            if arr[dy][dx] == "#" :
                arr[i][j] = "*"
                tmp = True
        if tmp == False :
            arr[i][j] = "."
pq = []
second = 0
heappush(pq, (second,arr[y1][x1],y1,x1))
while pq :
    second, prev, y, x = heappop(pq)
    if y == y2 and x == x2 : break
    if arr[y][x] == "V" : continue
    arr[y][x] = "V"
    for i in range(4) :
        dy = y + direct_y[i]
        dx = x + direct_x[i]
        if dy<1 or dx<1 or dy>=H-1 or dx>=W-1 or arr[dy][dx]=="V" or arr[dy][dx]=="#" : continue
        if prev == arr[dy][dx] == "*" :
            heappush(pq, (second,arr[dy][dx],dy,dx))
        else :
            heappush(pq, (second+1,arr[dy][dx],dy,dx))
print(second)