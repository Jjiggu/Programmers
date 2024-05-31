def solution(answers):
    result = []
    first_supo = "12345"
    second_supo = "21232425"
    third_supo = "3311224455"
    first_supo_num = 0
    second_supo_num = 0
    third_supo_num = 0
    supo = {}
    
    for index, num in enumerate(answers):
        if int(first_supo[index % len(first_supo)]) == num:
            first_supo_num += 1
            
        if int(second_supo[index % len(second_supo)]) == num:
            second_supo_num += 1
            
        if int(third_supo[index % len(third_supo)]) == num:
            third_supo_num += 1
    supo[1] = first_supo_num
    supo[2] = second_supo_num
    supo[3] = third_supo_num
    
    print(supo)
    

    final = []
#     max_num = -1
    
#     for key, value in supo.items():
#         if value > max_num: # 첫번째 value가 무조건 추가 됨
#             max_num = value
            
#         elif value == max_num:
#             final.append(key)
    
    final = [k for k,v in supo.items() if max(supo.values()) == v]

    
    return final