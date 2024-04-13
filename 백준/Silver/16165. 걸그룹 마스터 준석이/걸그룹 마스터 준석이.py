import sys
input = sys.stdin.readline
N, M = map(int, input().split())
info = {}
for _ in range(N) :
    group = input().rstrip()
    info[group] = set()
    n_member = int(input()) 
    for _ in range(n_member) :
        info[group].add(input().rstrip())

for _ in range(M) :
    x = input().rstrip()
    q = int(input())

    for k, v in info.items() :
        if q :
            if x in v :
                print(k)
        else :
            if x == k :
                print(*sorted(list(v)), sep="\n")