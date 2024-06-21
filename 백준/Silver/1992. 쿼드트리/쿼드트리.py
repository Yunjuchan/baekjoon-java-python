import copy
N = int(input())
A = [list(map(int, list(input()))) for _ in range(N)]
while N > 1 :
    newA = []
    for i in range(0,N,2) :
        tmp = []
        for j in range(0,N,2) :
            if A[i][j] == A[i][j+1] == A[i+1][j] == A[i+1][j+1] and (A[i][j] == 1 or A[i][j] == 0):
                tmp.append(A[i][j])
            else :
                tmp.append(f'({A[i][j]}{A[i][j+1]}{A[i+1][j]}{A[i+1][j+1]})')
        newA.append(tmp)
    A = copy.deepcopy(newA)
    N //= 2
print(A[0][0])