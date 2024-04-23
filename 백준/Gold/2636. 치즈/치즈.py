from collections import deque

N, M = map(int, input().split())
arr = []
'''
바깥 부분을 먼저 -1로 바깥 공기임을 만든다.
바깥 공기를 체크하며 주변 값이 1이라면 치즈 que에 넣음
치즈가 녹다가 공기가 주입되면 바깥 공기를 채우고 치즈를 넣어줌
'''

direct_y = [1,0,-1,0]
direct_x = [0,1,0,-1]

for _ in range(N) :
    arr.append(list(map(int, input().split())))

que = deque()
air = deque()
cheeze = deque()

air.append((0,0))
arr[0][0] = 2

def airing(level) :
    while air :
        y, x = air.popleft()
        for k in range(4) :
            dy = direct_y[k] + y
            dx = direct_x[k] + x
            if dy < 0 or dx < 0 or dy >= N or dx >= M or arr[dy][dx] == 2: continue
            if arr[dy][dx] == 1 :
                que.append((level+1, dy, dx))
            else :
                air.append((dy, dx))
                arr[dy][dx] = 2
airing(0)

dic = {}
dic2 = {}
def bfs(cnt) :
    global que
    cheeze = que
    que = deque()
    while cheeze :
        level, y, x = cheeze.popleft()
        if arr[y][x] == 2 : continue
        arr[y][x] = 2
        dic[level] = dic.get(level, 0) + 1
        dic2[(y, x)] = level
        for i in range(4) :
            dy = direct_y[i] + y
            dx = direct_x[i] + x
            if dy < 0 or dx < 0 or dy >= N or dx >= M or arr[dy][dx] == 2 : continue
            if arr[dy][dx] == 1 :
                que.append((level+1, dy, dx))
            else :
                air.append((dy, dx))
    airing(cnt)
    
cnt = 0
while que :
    cnt += 1
    bfs(cnt)
print(list(dic.items())[-1][0])
print(list(dic.items())[-1][1])