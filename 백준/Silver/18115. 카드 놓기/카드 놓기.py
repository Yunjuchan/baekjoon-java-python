from collections import deque
N = int(input())
arr = list(map(int, input().split()))
arr.reverse()
top = deque()
etc = deque()
for i in range(N) :
    if arr[i] == 1 :
        if top :
            etc.appendleft(top.pop())
        top.append(i+1)
    elif arr[i] == 2 :
        etc.appendleft(i+1)
    else :
        etc.append(i+1)
print(*top, *etc)