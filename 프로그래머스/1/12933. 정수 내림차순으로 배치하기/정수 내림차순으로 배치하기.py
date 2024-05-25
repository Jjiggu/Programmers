def solution(n):
    result_list = list(str(n))
    
    result_list.sort(reverse=True)
    
#     for i in str(n):
#         result_list.append(int(i))  
    
#     result_list.sort()
#     result_list.reverse()
    
#     for j in result_list:
#         answer += str(j)
    
    
    return int("".join(result_list))