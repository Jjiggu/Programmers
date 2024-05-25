def solution(n):
    answer = ""
    result_list = []
    
    for i in str(n):
        result_list.append(int(i))  
    
    result_list.sort()
    result_list.reverse()
    
    for j in result_list:
        answer += str(j)
    
    
    return int(answer)