while True :
    
    line = input().lower()
    if line == "#" : break
    cnt = 0
    cnt += line.count("a") + line.count("u") + line.count("o") + line.count("e") + line.count("i")
    print(cnt)