from heapq import heappop, heappush
import sys 
input = sys.stdin.readline
N = int(input())
que = []
for _ in range(N) :
    x = int(input())
    if len(que) == 0 :
        if x == 0 :
            print(0)
        else :
            heappush(que, x)
    else :
        if x == 0 :
            print(heappop(que))
            
        else :
            heappush(que, x)