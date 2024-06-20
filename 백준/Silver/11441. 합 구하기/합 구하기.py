import sys
input = sys.stdin.readline
N = int(input())
A = [0] + list(map(int, input().split()))
M = int(input())
for i in range(N) :
    A[i+1] += A[i]
for _ in range(M) :
    s, e = map(int, input().split())
    print(A[e] - A[s-1])