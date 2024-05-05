import sys
from collections import deque
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

top = [-1] * 1000001
result = [1] * 1000001
N = int(input())

def find(x) :
    if top[x] == -1 :
        return x
    ret = find(top[x])
    top[x] = ret
    return ret

def union(a, b) :
    fa, fb = map(find, (a, b))
    if fa == fb :
        return
    top[fb] = fa
    result[fa] += result[fb]

def answer(x) :
    print(result[find(x)])

for _ in range(N) :
    query = input().rstrip().split()
    if query[0] == "I" :
        union(int(query[1]), int(query[2]))
    else :
        answer(int(query[1]))