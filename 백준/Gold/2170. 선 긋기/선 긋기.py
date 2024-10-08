import sys
input = sys.stdin.readline
N = int(input().rstrip())
line = []
result = 0
last = -21e8
for _ in range(N) :
    line.append(list(map(int, input().split())))
line.sort(key=lambda x : (x[0], -x[1]))
for s, e in line :
    if s >= last:
        result += e - s
        last = e
    elif s < last <= e :
        result += e - last
        last = e
    else :
        continue
print(result)
