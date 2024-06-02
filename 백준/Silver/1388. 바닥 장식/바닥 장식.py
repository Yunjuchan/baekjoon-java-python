N, M = map(int, input().split())
direct_y = [0,1]
direct_x = [1,0]
shape = ['-', '|']
arr = []
for _ in range(N) :
    arr.append(list(input()))
def dfs(target, y, x) :
    arr[y][x] = '.'
    dy = direct_y[target] + y
    dx = direct_x[target] + x
    if dy<0 or dx<0 or dy>=N or dx>=M or arr[dy][dx] != shape[target] : return
    dfs(target, dy, dx)
        
result = 0
for i in range(N) :
    for j in range(M) :
        if arr[i][j] == '.' : continue
        if arr[i][j] == '-' : dfs(0, i, j)
        else : dfs(1, i, j)
        result += 1
print(result)