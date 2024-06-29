N, L = map(int, input().split())
A =list(map(int, input().split()))
D = A[:]
for i in range(N-2, 0, -1) :
    D[i] += D[i+1]
# print(D)
for i in range(1, N) :
    D[i] /= N-i
# print(D)
flag = True
for i in range(1, N) :
    if A[i-1]-L < D[i] < A[i-1] + L :
        continue
    flag = False
    break
if flag :
    print("stable")
else :
    print("unstable")