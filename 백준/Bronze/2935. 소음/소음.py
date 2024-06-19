A = input()
O = input()
B = input()
C = [0]*91
if O == '*' :
    print("1"+"0"*(len(A)+len(B)-2))
else :
    C[len(A)-1] += 1
    C[len(B)-1] += 1
    C.reverse()
    print(int(''.join(list(map(str,C)))))