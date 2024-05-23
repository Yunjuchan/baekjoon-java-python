x, y, w, h = map(int, input().split())
a = min(abs(x-w), abs(y), abs(x), abs(y-h))
print(a)