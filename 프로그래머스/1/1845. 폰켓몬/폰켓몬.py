from itertools import combinations
def solution(nums):
    poketmon_nums = len(nums) // 2
    # poket_list = list(combinations(nums, poketmon_nums))
    result = []
    answer = 0
    
    if len(set(nums)) < poketmon_nums:
        return len(set(nums))
    else:
#         for i in poket_list:
#             result.append(list(set(i)))

#             if len(list(set(i))) > answer:
#                 answer = len(list(set(i)))
            
        return poketmon_nums