def solution(food):
    answer = ''
    
    for i in range(1, len(food)):
        count = int(food[i]) // 2
        for j in range(count):
            answer = answer + str(i)
            
    answer = answer + str(0)
    
    for k in range(len(food)-1, 0, -1):
        count = food[k] // 2
        for h in range(count):
            answer = answer + str(k)
        
    
    return answer