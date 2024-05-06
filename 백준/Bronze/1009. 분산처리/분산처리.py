T = int(input())
arr = [[10], [1], [2, 4, 8, 6], [3, 9, 7, 1], 
       [4, 6], [5], [6], [7, 9, 3, 1], [8, 4, 2, 6], [9, 1]]
for _ in range(T) :
    a, b = map(int, input().split())
    print(arr[a % 10][(b-1) % len(arr[a % 10])])