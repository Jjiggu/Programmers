def pivo(n):
    if n == 1 or n == 2:
        return 1
    else:
        return pivo(n - 1) + pivo(n - 2)

def solution(n):
#     answer = 0
    
#     answer = pivo(n) % 1234567
    
    a,b = 1,1
    
    if n == 1 or n == 2:
        return 1
        
    for i in range(1, n):
        a, b = b, a+b

    answer = a % 1234567
    
    return answer