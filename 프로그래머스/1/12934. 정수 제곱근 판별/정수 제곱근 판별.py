def solution(n):
    answer = 0
    
    for i in range(1, n + 1):
        if i * i == n:
            answer = (i + 1)**2
            break
        else:
            answer = -1 
        
    return answer