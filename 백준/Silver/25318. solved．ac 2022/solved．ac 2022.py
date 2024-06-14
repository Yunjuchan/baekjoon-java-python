import datetime
N = int(input())

level = 0

def calcP(i, N, ti, tN) :
    return max(0.5**((tN-ti)/365), 0.9**(N-i))

def mean(p, l) :
    result = 0
    for i in range(N) :
        result += p[i]*l[i]
    result /= sum(p)
    return result

days = []
p = []
levels = []
tN = 0
time_format = "%Y/%m/%d %H:%M:%S"
epoch = datetime.datetime(2019, 6, 1)

for _ in range(N) :
    d, t, l = input().split()
    x = datetime.datetime.strptime(d+" "+t, time_format)
    td = int((x - epoch).total_seconds()) / (24 * 60 * 60)
    tN = td
    levels.append(int(l))
    days.append(td)

for i in range(N) :
    p.append(calcP(i+1, N, days[i], tN))
if N != 0 :
    level = mean(p, levels)
    
print(round(level))