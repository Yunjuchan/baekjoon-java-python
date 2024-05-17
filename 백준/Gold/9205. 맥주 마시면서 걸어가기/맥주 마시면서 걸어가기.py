from collections import deque

T = int(input())
result = []
for _ in range(T) :
    N = int(input())
    home = list(map(int, input().split()))
    visited = [False] * N
    arr = [list(map(int, input().split())) for _ in range(N)]
    festival = list(map(int, input().split()))
    
    que = deque()
    que.append((0,home[0],home[1]))
    while que :
        dist, y, x = que.popleft()
        if abs(festival[0] - y) + abs(festival[1] - x) <= (1000 - dist) :
            print("happy")
            break
        for i in range(N) :
            if visited[i] : continue
            if abs(arr[i][0] - y) + abs(arr[i][1] - x) > (1000 - dist) : continue
            que.append((dist % 50, arr[i][0], arr[i][1]))
            visited[i] = True
    else : 
        print("sad")