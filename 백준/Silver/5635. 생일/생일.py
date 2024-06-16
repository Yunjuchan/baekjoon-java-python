N=int(input())
P=[]
for _ in range(N):
 x=input().split()
 P.append((f'{x[3]}{int(x[2]):02}{int(x[1]):02}',x[0]))
P.sort()
print(P[-1][1])
print(P[0][1])