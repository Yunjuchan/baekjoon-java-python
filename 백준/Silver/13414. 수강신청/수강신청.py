import sys
input = sys.stdin.readline
K, L = map(int, input().split())
dic = {}
for i in range(L) :
    dic[input()] = i
arr = sorted(dic.items(), key=lambda x : x[1])
for i in range(min(K, len(arr))) :
    print(arr[i][0].rstrip())