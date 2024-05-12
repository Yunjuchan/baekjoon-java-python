N = int(input())
A = list(map(int, input().split()))

arr = [0] * N
x = []
for i in range(N) :
    x.append((A[i], i))
x.sort(key=lambda x : x[0])
for i in range(N) :
    arr[x[i][1]] = i
print(*arr)