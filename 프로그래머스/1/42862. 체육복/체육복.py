def solution(n, lost, reserve):
    result = 0    
    lost.sort()
    reserve.sort()
    
    non_reserve = [i for i in lost if i not in reserve]
    reserve = [i for i in reserve if i not in lost]
            
    for i in range(1, n + 1):
        if i not in non_reserve and i not in reserve:
            result += 1
        
    
    for student in reserve:
        if student - 1 in non_reserve:
            result += 2
            non_reserve.remove(student - 1)
            
        elif student + 1 in non_reserve:
            result += 2
            non_reserve.remove(student + 1)
            
        else:
            result += 1
    
    
    # return result
    return n - len(non_reserve)
    
    