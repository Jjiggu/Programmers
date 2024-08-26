def solution(dartResult):
    answer = 0
    bonus = {"S" : 1,
            "D" : 2,
            "T" : 3}
    option = {"*" : 2,
             "#" : -1}
    
    num_list = []
    temp = ""
    
    for i in dartResult:
        if i.isdigit():
            # 점수 저장
            temp += i
            
        elif i.isalpha():
            num_list.append(pow(int(temp), bonus[i]))
            temp = ""
            
        elif i == "*":
            if len(num_list) > 1:
                num_list[-2] *= 2
            num_list[-1] *= 2
            
        elif i == "#":
            num_list[-1] *= (-1)
    
    result = sum(num_list)
    
    return result
