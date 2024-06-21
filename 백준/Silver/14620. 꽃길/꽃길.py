N = int(input())
A = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
direct_y = [0,1,0,-1,0,2,0,-2,0,1,1,-1,-1]
direct_x = [0,0,1,0,-1,0,2,0,-2,1,-1,1,-1]

result = 21e8
def dfs(n, c) :
    global result
    if n == 3 :
        if result > c :
            result = c
        return
    for y in range(1, N-1) :
        for x in range(1, N-1) :
            if visited[y][x] : continue
            cost = 0
            for i in range(13) :
                dy = direct_y[i] + y
                dx = direct_x[i] + x
                if dy<0 or dx<0 or dy>=N or dx>=N : continue
                if i<5: 
                    cost += A[dy][dx]
                visited[dy][dx] += 1
            dfs(n+1, c+cost)
            for i in range(13) :
                dy = direct_y[i] + y
                dx = direct_x[i] + x
                if dy<0 or dx<0 or dy>=N or dx>=N : continue
                visited[dy][dx] -= 1
dfs(0,0)
print(result)