def Min(a, b) :
    ret = INF
    s = leaf+a
    e = leaf+b
    while s <= e :
        if s % 2 :
            if ret > tree[s] :
                ret = tree[s]
        s += 1
        if not e % 2 :
            if ret > tree[e] :
                ret = tree[e]
        e -= 1
        s //= 2
        e //= 2
    return ret            


import sys
input = sys.stdin.readline
N, M = map(int, input().split())
INF = 21e8

i = 0
while True :
    if 2 ** i >= N :
        break
    i += 1
leaf = 2 ** i - 1
tree = [INF] * 2 ** (i+1)
for i in range(1, N+1) :
    tree[leaf+i] = int(input().rstrip())

for i in range(leaf, 0, -1) :
    tree[i] = min(tree[i*2], tree[i*2+1])
for _ in range(M) :
    a, b = map(int, input().split())
    ret = Min(a, b)
    print(ret)
