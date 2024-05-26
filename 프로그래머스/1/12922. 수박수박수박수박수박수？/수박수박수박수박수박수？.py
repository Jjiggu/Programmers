def solution(n):
    answer = ''
    word = "수박"
    
    for i in range(1, n + 1):
        answer += word[(i % 2) - 1]  
    
    return answer