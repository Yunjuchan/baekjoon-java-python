N = int(input())
s = set(map(int, input().split()))
M = int(input())

result = []
for x in map(int, input().split()) :
    if x in s :
        result.append(1)
    else : result.append(0)
    
print(*result)