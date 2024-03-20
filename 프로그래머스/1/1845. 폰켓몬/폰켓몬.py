def solution(nums):
    dic = {}
    for num in nums:
        dic[num] = dic.get(num, 0) + 1
    answer = min(len(dic.items()), len(nums) // 2)
    return answer