import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
def changedp(x) :
    for i in adj[x] :
        if i == par[x] : continue
        changedp(i)
        dp[x] += dp[i]

def setparent(a, b) : 
    if par[b] == a : return
    if par[a] == b : return
    if par[a] == par[b] == -1 :
        return 
    
    elif par[a] != -1 :
        par[b] = a
        for i in adj[b] :
            setparent(b, i)
    elif par[b] != -1 :
        par[a] = b
        for i in adj[a] :
            setparent(a, i)
    else :
        return 
            
N, R, Q = map(int, input().split())
adj = [[] for _ in range(N+1)]
par = [-1] * (N+1)
dp = [1] * (N+1)
par[R] = R
for _  in range(N-1) :
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)
    setparent(a, b)

changedp(R)
for _ in range(Q) :
    print(dp[int(input().rstrip())])