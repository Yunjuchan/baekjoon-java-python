T = int(input())
for _ in range(T) :
    c, *lst = list(map(int, input().split()))
    avg = sum(lst) / c
    cnt = 0
    for x in lst :
        if x > avg :
            cnt += 1
    print(f'{100 * cnt/c :.3f}%')