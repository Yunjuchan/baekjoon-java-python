from collections import deque
N, M, P = map(int, input().split())
arr = [0]+list(map(int, input().split()))

S = [list(input()) for _ in range(N)]
ques = [deque() for _ in range(P+1)]
direct_y = [1,0,-1,0]
direct_x = [0,1,0,-1]
cnt = [0] * (P+1)

def bfs(que, i) :
    result = 0
    nextq = deque()
    while que :
        y, x, k = que.popleft()
        if k == arr[i] :
            nextq.append((y, x, 0))
            continue
        for j in range(4) :
            dy = direct_y[j] + y
            dx = direct_x[j] + x
            if dy<0 or dx<0 or dy>=N or dx>=M or S[dy][dx] != '.': continue
            S[dy][dx] = i
            cnt[i] += 1
            que.append((dy, dx, k+1))
            result = 1
    ques[i] = nextq
    return result
            
for i in range(N) :
    for j in range(M) :
        if str.isdigit(S[i][j]):
            S[i][j] = int(S[i][j])
            ques[S[i][j]].append((i, j, 0))
            cnt[S[i][j]] += 1

tmp = 1
while tmp :
    tmp = 0
    for i in range(1, P+1) :
        tmp += bfs(ques[i], i)
        
print(*cnt[1:])