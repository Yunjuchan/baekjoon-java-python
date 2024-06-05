A=[9]*(10**5+1)
A[0]=0
for i in range(1, 100001): 
    for j in range(1,int(i**(1/2)+1)):A[i]=min(A[i],A[i-j**2]+1)
print(A[int(input())])