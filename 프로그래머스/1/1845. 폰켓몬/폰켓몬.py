def solution(nums):
#     poketmon_nums = len(nums) // 2
    
#     if len(set(nums)) < poketmon_nums:
#         return len(set(nums))
#     else:   
#         return poketmon_nums
    return min(len(set(nums)), len(nums)//2)