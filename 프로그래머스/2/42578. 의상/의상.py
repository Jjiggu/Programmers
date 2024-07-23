from collections import Counter

def solution(clothes):
    result = 0
    re = 0
    clothes_dic = {i[1]:[] for i in clothes}
    
    clothes_cnt = Counter([kind for name, kind in clothes])
          
    # Counter 사용해서 개수만 저장하면 될 듯 -> 굳이 요소를 저장 후 len 함수 사용할 필요 없을듯
    for i in range(len(clothes)):
        clothes_dic[clothes[i][1]] += [clothes[i][0]]
     
    # 1. 하나 이상의 항목 입는 경우 -> list 원소 개수의 곱 
    if len(clothes_dic) > 1:
        two_result = 1
        t_result = 1
        for key, value in clothes_dic.items():
            two_result *= len(value) + 1
        
        for key, value in clothes_cnt.items():
            t_result *= value + 1
        
        # return result + two_result - 1
        return result + t_result - 1
    
    # 2. 하나의 항목만 입는 경우 -> 각 key값의 list 원소 개수
    else:
        for key, value in clothes_dic.items():
            result += len(value)
        
        for key, value in clothes_cnt.items():
            re += value
            
        return re
    