encode = input()
N = len(encode)
R = 0
C = 0
for i in range(1, int(N**.5)+1) :
    if N % i == 0 :
        C, R = i, N // i
decode = ""
for j in range(C) :
    for i in range(R) :
        decode += encode[i*C+j]
print(decode)