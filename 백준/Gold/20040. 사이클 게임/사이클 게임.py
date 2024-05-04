import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


N, M = map(int, input().split())
cycle = [-1] * N

def find(x, arr) :
    if arr[x] == -1 :
        return x
    ret = find(arr[x], arr)
    arr[x] = ret
    return ret

def union(a, b, arr) :
    fa = find(a, arr)
    fb = find(b, arr)
    if fa == fb :
        return True
    arr[fb] = fa
    return False
    
for i in range(M) :
    a, b = map(int, input().split())
    isCycle = union(a, b, cycle)
    if isCycle :
        print(i+1)
        break
else :
    print(0)