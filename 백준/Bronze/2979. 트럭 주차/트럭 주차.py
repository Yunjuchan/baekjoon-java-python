C = [0] + list(map(int, input().split()))
T = [0] * 102
N = 0
for _ in range(3) :
    s, e = map(int, input().split())
    T[s] += 1
    T[e] -= 1
result = 0
for i in range(101) :
    N += T[i]
    result += C[N]*N
print(result)