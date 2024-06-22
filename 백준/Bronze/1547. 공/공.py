A = [0,1,2,3]
N = int(input())
for _ in range(N) :
    x, y = map(int, input().split())
    A[x], A[y] = A[y], A[x]

for i in range(4) :
    if A[i] == 1 :
        print(i)