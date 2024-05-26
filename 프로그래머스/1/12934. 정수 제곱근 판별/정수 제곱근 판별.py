def solution(n):
    answer = 0
    
#     for i in range(1, n + 1):
#         if i * i == n:
#             answer = (i + 1)**2
#             break
#         else:
#             answer = -1 
    
#     return answer
    
    sqrt = n ** (1/2)

    if sqrt % 1 == 0:
        return (sqrt + 1) ** 2
    return -1