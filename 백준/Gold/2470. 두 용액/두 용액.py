N = int(input())
arr = sorted(list(map(int, input().split())))
Min = 21e8
result = []
i, j = 0, N-1
while i < j :
    if Min > abs(arr[j] + arr[i]) :
        Min = abs(arr[j] + arr[i])
        result = [arr[i], arr[j]]
    if arr[j] + arr[i] > 0 :
        j -= 1
    elif arr[j] + arr[i] < 0 : 
        i += 1
    else : break
print(*result)