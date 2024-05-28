from collections import deque
front = deque(input())
back = deque()

n = int(input())
def edit(command, char="") :
    if command == "P" :
        front.append(char)
    
    if command == "L" :
        if front :
            char = front.pop()
            back.appendleft(char)
        
    if command == "D" :
        if back :
            char = back.popleft()
            front.append(char)
            
    if command == "B" :
        if front :
            front.pop()

for _ in range(n) :
    edit(*input().split())
print(*front, *back, sep="")