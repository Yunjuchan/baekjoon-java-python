ts = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
result_list = [[] for _ in range(36)]
N = int(input())
word = []
for _ in range(N) :
    x = input().rstrip()
    i = 0
    while i < len(x) :
        if x[i] == '0' :
            i += 1
        else :
            break
    if i == len(x) :
        word.append('0')
    else :
        word.append(x[i:])

K = int(input())
lst = [[] for _ in range(50)]

for x in word :
    M = len(x)
    for i in range(M) :
        lst[M-i-1].append(x[i])
        
change_list = [0] *36
for i in range(50) :
    for j in lst[i] :
        if j.isdigit() :
            change_list[ord(j)-48] += (35-ts.index(j)) * 36 ** i
        else :
            change_list[ord(j)-55] += (35-ts.index(j)) * 36 ** i
choose_list = list(enumerate(change_list))
choose_list.sort(key=lambda x : -x[1])
cnt = 0
while cnt < K :
    flag = 0
    for i in range(50) :
        for j in range(len(lst[i])) :
            if lst[i][j] == ts[choose_list[cnt][0]] :
                flag = 1
                lst[i][j] = 'Z'
    if flag == 0 :
        break
    else :
        cnt += flag
for i in range(50) :
    for j in lst[i] :
        if j.isdigit() :
            result_list[ord(j)-48].append(i)
        else :
            result_list[ord(j)-55].append(i)
result = 0
for i in range(36) :
    for j in result_list[i] :
        result += i * 36 ** j
ts_result = ''
while result :
    ts_result = ts[result%36] + ts_result
    result //= 36
if set(word) == {'0'} :
    print(0)
else :
    print(ts_result)

