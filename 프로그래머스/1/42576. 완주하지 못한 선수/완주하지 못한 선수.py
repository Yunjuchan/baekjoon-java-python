def solution(participant, completion):
    dic = {}
    for p in participant :
        dic[p] = dic.get(p, 0) + 1
    for c in completion :
        dic[c] = dic.get(c) - 1
    answer = sorted(dic.items(), key=lambda x: -x[1])[0][0]
    return answer