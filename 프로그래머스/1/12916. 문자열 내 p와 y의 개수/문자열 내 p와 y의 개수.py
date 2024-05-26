def solution(s):
    count_p = s.count('p')
    count_P = s.count('P')
    
    result_p = count_p + count_P
    
    count_y = s.count('y')
    count_Y = s.count('Y')
    
    result_y = count_y + count_Y
    
    if result_p == result_y:
        return True
    else:
        return False
