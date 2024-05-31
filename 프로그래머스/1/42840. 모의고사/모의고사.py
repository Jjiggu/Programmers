def solution(answers):
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

    
    return [k for k,v in supo.items() if max(supo.values()) == v]