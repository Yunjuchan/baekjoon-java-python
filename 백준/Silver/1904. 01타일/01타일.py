N = int(input())
D = [i for i in range(N+1)]

for i in range(3, N+1) :
    D[i] = (D[i-1] + D[i-2]) % 15746
print(D[N])