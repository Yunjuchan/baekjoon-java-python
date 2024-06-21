## 양수 사이클이 도착지로 적용이 될 때와 안될때를 나눠서 분기를 해주어야함
N, start, end, M = map(int, input().split())
edge = []
MIN = -21e8
MAX = 21e8
total_p = [MIN] * N
for _ in range(M) :
    edge.append(list(map(int, input().split())))
profit = list(map(int, input().split()))
total_p[start] = profit[start]
for i in range(N+100) :
    for s, e, w in edge :
        if total_p[s] == MIN : continue
        if total_p[e] < total_p[s] - w + profit[e] :
            if i <= N-1 :
                total_p[e] = total_p[s] - w + profit[e]
            else :
                total_p[e] = MAX
if total_p[end] == MAX :
    print('Gee')
elif total_p[end] == MIN :
    print('gg')
else :
    print(total_p[end])