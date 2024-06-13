import sys
input = sys.stdin.readline
arr = [0] * 120002
N = int(input())

for _ in range(N) :
    date = input().rstrip().replace("-", " ").split()
    date = list(map(int, date))
    arr[date[0]*12+date[1]] += 1
    arr[date[2]*12+date[3]+1] -= 1
Max = 0
t = 0
for i in range(24000, 120001) :
    arr[i] += arr[i-1]
    if Max < arr[i] :
        Max = arr[i]
        t = i
year = t // 12
month = t % 12
if month == 0:
    year -= 1
    month = 12
print(f'{year}-{month:02}')