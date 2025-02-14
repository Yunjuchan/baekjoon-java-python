import sys
input = sys.stdin.readline
N = int(input().rstrip())
A = []
for _ in range(N) :
    x = int(input().rstrip())
    A.append(x)

B = sorted(A, reverse=True)

# H는 원래 실력대로의 순위
H = {}
for i in range(N) :
    H[B[i]] = i
i = 0 
while True :
    if 2 ** i >= N :
        break
    i += 1
leaf = 2 ** i - 1
tree = [0] * 2 ** (i+1)

def changeTree(node, s, e, i) :
    if i < s or i > e :
        return
    if s == e :
        tree[node] += 1
        return
    changeTree(node*2, s, (s+e)//2, i)
    changeTree(node*2+1, (s+e)//2+1, e, i)
    tree[node] = tree[node*2] + tree[node*2+1]

def query(node, s, e, l, r) :
    if l > e or r < s :
        return 0
    if l <= s and e <= r :
        return tree[node]
    lsum = query(node*2, s, (s+e)//2, l, r)
    rsum = query(node*2+1, (s+e)//2+1, e, l, r)
    return lsum+rsum


for i in range(N) :
    l = H[A[i]] + 1
    r = leaf
    print(i - query(1, 0, leaf, l, r)+1)
    changeTree(1, 0, leaf, l-1)