def solution(clothes):
    result = 0
    
    clothes_dic = {i[1]:[] for i in clothes}
    
    for i in range(len(clothes)):
        clothes_dic[clothes[i][1]] += [clothes[i][0]]
    
    # 조합
    # 1. 하나의 항목만 입는 경우 -> 각 key값의 list 원소 개수 
    # one_result = 0
    # for key, value in clothes_dic.items():
    #     one_result += len(value)
    
    # 2. 하나 이상의 항목 입는 경우 -> list 원소 개수의 곱 
    # 항목이 하나 이상인 경우는 해당 x
    two_result = 0
    one_result = 0
    
    if len(clothes_dic) > 1:
        two_result = 1
        for key, value in clothes_dic.items():
            two_result *= len(value) + 1
        
        return one_result + two_result - 1
    
    
    else:
        for key, value in clothes_dic.items():
            one_result += len(value)
        
        return one_result
    