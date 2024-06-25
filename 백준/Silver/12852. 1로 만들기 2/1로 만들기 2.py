N = int(input())
D = [(-1, 21e8)] * (N+1)
D[1] = (1, 0)
for i in range(2, N+1) :
    A=B=C=21e8
    
    if not i % 3 :
        A = D[i//3][1]
    if not i % 2 :
        B = D[i//2][1]
    C = D[i-1][1]
    if min((A, B, C)) == A :
        D[i] = (i//3, A+1)
    elif min((A, B, C)) == B :
        D[i] = (i//2, B+1)
    else :
        D[i] = (i-1, C+1)
R = [N]
print(D[N][1])
while N != 1 :
    N = D[N][0]
    R.append(N)
print(*R)