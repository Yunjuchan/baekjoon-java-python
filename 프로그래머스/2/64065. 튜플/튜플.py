def solution(s):
    answer = []
    s = s.replace('{', '')
    s = s.replace('}', '')
    s = list(map(int, s.split(',')))
    dic = {}
    for i in s:
        dic[i] = dic.get(i, 0) + 1
    for k, v in sorted(dic.items(), key=lambda x: -x[1]):
        answer.append(k)
    
    return answer