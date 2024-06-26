T = int(input())
for _ in range(T) :
    N = int(input())
    A = [list(map(int, input().split())) for _ in range(2)]
    D = [[0]*N for _ in range(2)]
    D[0][0] = A[0][0]
    D[1][0] = A[1][0]
    if N > 1 :
        D[0][1] = D[1][0] + A[0][1]
        D[1][1] = D[0][0] + A[1][1]
    
    for i in range(2,N) :
        for j in range(2) :
            D[j][i] = max(D[0][i-2], D[1][i-2], D[j^1][i-1]) + A[j][i]
    print(max(D[0][N-1], D[1][N-1]))