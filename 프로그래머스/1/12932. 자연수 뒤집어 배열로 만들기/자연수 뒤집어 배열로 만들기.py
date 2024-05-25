def solution(n):
#     result_list = list(str(n))
#     result = []
    
#     result_list.reverse()
    
#     for i in result_list:
#         result.append(int(i))
        
    n = str(n)[::-1] 
    result = list(map(int, n))
    
    
    return result