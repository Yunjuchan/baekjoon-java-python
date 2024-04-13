import sys
input = sys.stdin.readline
T = int(input().rstrip())
for _ in range(T) :
    N = int(input().rstrip())
    dic = {}
    for _ in range(N) :
        x, y = input().rstrip().split()
        dic[y] = dic.get(y,  []) + [x]
    result = 1
    for x in dic.values() :
        result *= (len(x)+1)
    print(result-1)