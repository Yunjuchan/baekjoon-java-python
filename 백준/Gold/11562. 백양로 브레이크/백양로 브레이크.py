import sys
input = sys.stdin.readline
N, M = map(int, input().split())
INF = 21e8
adj = [[INF] * (N+1) for _ in range(N+1)]
for _ in range(M) :
    s, e, b = map(int, input().split())
    adj[s][e] = 0
    adj[e][s] = 1
    if b == 1 :
        adj[e][s] = 0
for i in range(1,N+1) :
    adj[i][i] = 0
for k in range(1,N+1) :
    for i in range(1,N+1) :
        if i == k : continue
        for j in range(1,N+1) :
            if j == i or j == k : continue
            if adj[i][k] + adj[k][j] < adj[i][j] :
                adj[i][j] = adj[i][k] + adj[k][j]
K = int(input())
for _ in range(K) :
    s, e = map(int, input().split())
    print(adj[s][e])
