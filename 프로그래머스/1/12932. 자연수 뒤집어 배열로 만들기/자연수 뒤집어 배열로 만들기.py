def solution(n):
    result_list = list(str(n))
    result = []
    
    result_list.reverse()
    
    for i in result_list:
        result.append(int(i))
    
    
    return result