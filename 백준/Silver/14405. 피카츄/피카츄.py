word = input()
word = word.replace("pi", "0")
word = word.replace("ka", "0")
word = word.replace("chu", "0")
word = word.replace("0", "")
if word == "" :
    print("YES")
else :
    print("NO")