import sys
input = sys.stdin.readline
N,M = map(int,input().split())
for _ in range(N):input()
R=G=B=0
for _ in range(M):
    a,b,c=input().rstrip().split()
    if c=='R':R+=1
    elif c=='G':G+=1
    else:B+=1
k=G//2
R+=k+G%2
B+=k
if R>B:print("jhnah917")
else:print("jhnan917")