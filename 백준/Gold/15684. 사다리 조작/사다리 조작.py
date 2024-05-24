import sys
input = sys.stdin.readline
N, M, H = map(int, input().split())
ladder = [[0] * (N+1) for _ in range(H+1)]

for _ in range(M) :
    a, b = map(int, input().split())
    ladder[a][b] = 1
    ladder[a][b+1] = -1

result = 4

def dfs(level, x):
    global result
    if level >= result:
        return
    if down():
        result = min(result, level)
        return
    
    for i in range(x, H+1):
        for j in range(1, N):
            if ladder[i][j] == 0 and ladder[i][j+1] == 0:
                ladder[i][j] = 1
                ladder[i][j+1] = -1
                dfs(level + 1, i)
                ladder[i][j] = 0
                ladder[i][j+1] = 0
        
def down() :
    for i in range(1, N+1) :
        now = i
        for j in range(1, H+1) :
            now += ladder[j][now]
        if now != i :
            return False
    return True

dfs(0, 1)
if result > 3 : print(-1)
else :print(result)